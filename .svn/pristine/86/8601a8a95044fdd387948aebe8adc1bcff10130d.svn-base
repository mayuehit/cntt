package com.sitech.cntt.fortress.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitech.cntt.inter.FortressTestMapper;

/**
 * @author: wujc
 * @date: 2020/6/5
 * @Description: 定时job样例service实现类
 */
@Service
public class TimerTaskExecutorService implements com.sitech.cntt.fortress.service.TimerTaskExecutorService {
	
	Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private FortressTestMapper fortressTestMapper;
	
	public final static String remark = "定时任务执行完成";
	
	@Override
	public void execute() {
		fortressTestMapper.updateRemark(remark);
	}

}
