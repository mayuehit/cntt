package com.sitech.cntt.common;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * @author: wujc
 * @date: 2020/6/24
 * @Description: 缓存配置
 */
@Configuration
public class CacheConfig {

	@Bean("localCache")
	public Cache<Object, Object> localCache() {
		Cache<Object, Object> cache = Caffeine.newBuilder()
		          //基于时间失效->写入之后开始计时失效
		          .expireAfterWrite(2400, TimeUnit.HOURS)
		          .maximumSize(10000)
		          .build();
		return cache;
	}
}
