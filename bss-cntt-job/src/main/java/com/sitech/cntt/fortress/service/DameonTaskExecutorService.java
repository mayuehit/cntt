package com.sitech.cntt.fortress.service;

/**
 * @author: wujc
 * @date: 2020/6/12
 * @Description: 守护job service
 */
public interface DameonTaskExecutorService {
	public void execute(Object input);
	public String fetchData();
}
