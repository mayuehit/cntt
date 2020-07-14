package com.sitech.cntt.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.sitech.cntt.inter.IaServconfigDictMapper;
import com.sitech.cntt.metadata.domain.IaServconfigDict;

/**
 * @author: wujc
 * @date: 2020/6/29
 * @Description: 启动加载类，查询服务配置信息列表存储至redis
 */
@Component
public class IaServconfigDictRunner implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(IaServconfigDictRunner.class);
	
	@Value("${cntt.iaservconfigdictlist_redis_key}")
	private String key;
	
	@Autowired
	private IaServconfigDictMapper iaServconfigDictMapper;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("查询服务配置信息列表存储至redis--start");
		
		List<IaServconfigDict> iaServconfigDictList = iaServconfigDictMapper.selectAll();
		// 更新redis缓存
		redisTemplate.opsForValue().set(key, iaServconfigDictList);
		log.info("服务配置信息列表已存储至redis");
		
		log.info("查询服务配置信息列表存储至redis--end");
	}

}
