package com.sitech.cntt.client;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.benmanes.caffeine.cache.Cache;
import com.sitech.cntt.metadata.domain.IaServconfigDict;
import com.sitech.cntt.vo.GetIaServconfigDictByRedisRsp;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.support.MBean;

/**
 * @author: wujc
 * @date: 2020/6/30
 * @Description: 启动加载类，远程调用接口获取服务配置信息列表并缓存至caffeine。内置定时任务，当缓存中无服务配置信息时，远程调用接口获取服务配置信息列表并缓存至caffeine。
 */
@Component
public class IaServconfigDictRunner implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(IaServconfigDictRunner.class);
	
	@Resource
	protected IServiceClient serviceClient;
	@Resource(name = "localCache")
	private Cache<Object, Object> cache;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		getServconfigPutcaffeine();
	}

	@Scheduled(cron="0 * * * * ?")
	public void judgeIaServconfigDictList() {
		List<IaServconfigDict> iaServconfigDictlist = (List<IaServconfigDict>)cache.getIfPresent("IA_SERVCONFIG_DICT_LIST");
		if (null == iaServconfigDictlist || iaServconfigDictlist.size()==0) {
			log.info("检测到缓存中无服务配置信息");
			getServconfigPutcaffeine();
		}
	}
	
	private void getServconfigPutcaffeine() {
		
		log.info("远程调用获取服务配置信息start");
		
		MBean outDTO  = serviceClient.callService("http://bss-cntt-query/com_sitech_cntt_inter_IIaServconfigDictQuerySvc_getIaServconfigDictByRedis",
		        null, MBean.class, ArchitectureType.SPRINGCLOUD);
		
		log.info("远程调用获取服务配置信息end:" + outDTO.toString());

		String return_code = Optional.ofNullable(outDTO)
				.flatMap(mapper -> Optional.ofNullable(mapper.getBodyStr("RETURN_CODE")))
				.orElse(null);
		if ("0".equals(return_code)) {
			List<IaServconfigDict> iaServconfigDictList = Optional.ofNullable(outDTO)
					.flatMap(mapper -> Optional.ofNullable(mapper.getBodyObject("OUT_DATA",GetIaServconfigDictByRedisRsp.class)))
					.flatMap(mapper -> Optional.ofNullable(mapper.getIaServconfigDictList()))
					.orElse(null);
			if (null != iaServconfigDictList && iaServconfigDictList.size()>0) {
				cache.put("IA_SERVCONFIG_DICT_LIST", iaServconfigDictList);
				log.info("服务配置列表已缓存");
			}
		}
	}
}
