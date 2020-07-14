package com.sitech.cntt.fortress.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.sitech.cntt.fortress.service.GetServconfigSetRedisService;
import com.sitech.cntt.inter.IaServconfigDictMapper;
import com.sitech.cntt.metadata.domain.IaServconfigDict;

/**
 * @author: wujc
 * @date: 2020/6/29
 * @Description: 查询服务配置信息列表存储至redis Service实现类
 */
@Service
public class GetServconfigSetRedisServiceImpl implements GetServconfigSetRedisService {

	private static final Logger log = LoggerFactory.getLogger(GetServconfigSetRedisServiceImpl.class);
	
	@Value("${cntt.iaservconfigdictlist_redis_key}")
	private String key;
	
	@Autowired
	private IaServconfigDictMapper iaServconfigDictMapper;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * @author: wujc
	 * @date: 2020/6/29
	 * @Description: 每隔一分钟，查询服务配置信息列表存储至redis
	 */
	@Override
	public void execute() {
		
		log.info("查询服务配置信息列表存储至redis--start");
		
		try {
			List<IaServconfigDict> iaServconfigDictList = iaServconfigDictMapper.selectAll();
			// 更新redis缓存
			redisTemplate.opsForValue().set(key, iaServconfigDictList);
			log.info("服务配置信息列表已存储至redis");
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		log.info("查询服务配置信息列表存储至redis--end");
	}

}
