package com.sitech.cntt.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sitech.cntt.common.EsUtil;
import com.sitech.cntt.common.IdmmUtil;
import com.sitech.ijcf.boot.core.aop.SvcMethodInterceptor;
import com.sitech.ijcf.boot.core.aop.SvcMethodInterceptorPriority;

/**
 * @author: wujc
 * @date: 2020/6/18
 * @Description: 服务切面，存储服务信息至es，存储id至idmm
 */
@Configuration
public class CnttSvcEsAop implements SvcMethodInterceptor{

	private static final Logger log = LoggerFactory.getLogger(CnttSvcEsAop.class);
	
	@Autowired
	private EsUtil esUtil;
	@Autowired
	private IdmmUtil idmmUtil;
	@Value("${cntt.es_address}")
	private String cnttEsAddress;
	@Value("${cntt.idmm_serverAddress}")
	private String idmmServerAddress;
	@Value("${cntt.idmm_clientId}")
	private String idmmClientId;
	@Value("${cntt.idmm_topic}")
	private String idmmTopic;
	@Value("${cntt.idmm_timeout}")
	private int idmmTimeout;
	
	@Override
	public SvcMethodInterceptorPriority getPriority() {
		return SvcMethodInterceptorPriority.COMMON_AFTER2;
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Method method = invocation.getMethod();
    	log.info("类名："+method.getDeclaringClass().getName()+"，方法名："+method.getName());
    	
    	Object[] reqObj = invocation.getArguments(); 
    	if (null != reqObj && reqObj.length>0) {
    		String paramJson = JSON.toJSONString(reqObj[0]);
    		log.info("入参："+paramJson);
    		// es索引文档
    		Thread thread = new Thread(new Runnable() {				
				@Override
				public void run() {
					String index = "testcompany2";
					String type = "employee";
					JSONObject jsonObject = JSONObject.parseObject(paramJson);
					String id = null;
					try {
						id = esUtil.insert(cnttEsAddress,index, type, jsonObject);
						if (null != id && !"".equals(id)) {
							idmmUtil.producer(idmmServerAddress, idmmClientId, idmmTopic, idmmTimeout, id);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
            thread.start();
		}  
    	
        Object retObj = invocation.proceed();
        log.info("出参："+JSON.toJSONString(retObj));
        return retObj;
	}

}
