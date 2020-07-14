package com.sitech.cntt.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;
import com.github.benmanes.caffeine.cache.Cache;
import com.sitech.cntt.common.CnttSvc;
import com.sitech.cntt.common.IdmmUtil;
import com.sitech.cntt.metadata.domain.IaServconfigDict;
import com.sitech.ijcf.boot.core.aop.SvcMethodInterceptor;
import com.sitech.ijcf.boot.core.aop.SvcMethodInterceptorPriority;

/**
 * @author: wujc
 * @date: 2020/6/8
 * @Description: 服务切面，存储服务信息至idmm
 */
@Configuration
public class CnttSvcLogAop implements SvcMethodInterceptor {

	private static final Logger log = LoggerFactory.getLogger(CnttSvcLogAop.class);
	
	@Autowired
	private IdmmUtil idmmUtil;
	@Resource(name = "localCache")
	private Cache<Object, Object> cache;
	@Value("${cntt.idmm_serverAddress}")
	private String idmmServerAddress;
	@Value("${cntt.idmm_clientId}")
	private String idmmClientId;
	@Value("${cntt.idmm_topic}")
	private String idmmTopic;
	@Value("${cntt.idmm_timeout}")
	private int idmmTimeout;	
	@Value("${cntt.app_code}")
	private String cnttAppCode;
	
    @Override
    public SvcMethodInterceptorPriority getPriority() {
        return SvcMethodInterceptorPriority.COMMON_AFTER1;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    	
    	Object[] reqObj = methodInvocation.getArguments(); 
    	if (null != reqObj && reqObj.length>0) {
    		log.info("入参："+JSON.toJSONString(reqObj[0]));		
    		Thread thread = new Thread(new Runnable() {	
				@Override
				public void run() {
					try {
						// 获取服务实现类路径和方法名
						Method method = methodInvocation.getMethod();
				    	String className = method.getDeclaringClass().getName();
				    	String methodName = method.getName();
				    	log.info("服务实现类路径：" + className + "，方法名：" + methodName);
				    	// 判断方法是否有@CnttSvc注解
				    	if (null != method.getAnnotation(CnttSvc.class)) {
							//有@CnttSvc注解，无需服务校验，直接生产消息
				    		idmmUtil.producer(idmmServerAddress, idmmClientId, idmmTopic, idmmTimeout, JSON.toJSONString(reqObj[0]));
						}else {
							List<IaServconfigDict> iaServconfigDictlist = (List<IaServconfigDict>)cache.getIfPresent("IA_SERVCONFIG_DICT_LIST");
							if (null != iaServconfigDictlist && iaServconfigDictlist.size()>0) {
								for (IaServconfigDict servconfig : iaServconfigDictlist) {
									String[] strings = servconfig.getServPath().split(",");
									// 判断APP_CODE、服务实现类路径和方法名是否匹配
									if (cnttAppCode.equals(servconfig.getAppCode()) && className.equals(strings[0]) && methodName.equals(strings[1])) {
										// 往原始主题上发布请求入参信息
										log.info("服务校验成功");
										idmmUtil.producer(idmmServerAddress, idmmClientId, idmmTopic, idmmTimeout, JSON.toJSONString(reqObj[0]));
										break;
									}
								}
							} else {
								log.info("没有获取到缓存");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}   				
				}
			});
            thread.start();
		}  
    	
        Object retObj = methodInvocation.proceed();
        log.info("出参："+JSON.toJSONString(retObj));
        return retObj;
    }

}
