package com.sitech.cntt.fortress.dataflow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.sitech.cntt.JobApplication;
import com.sitech.cntt.fortress.service.TimerTaskExecutorService;
import com.sitech.fortress.task.JobContext;
import com.sitech.fortress.task.TimerTaskExecutor;

/**
 * @author: wujc
 * @date: 2020/6/5
 * @Description: 定时job样例
 */
public class TimerTaskExecutorSampleJob implements TimerTaskExecutor{
	
	Logger log = LogManager.getLogger(TimerTaskExecutorSampleJob.class);
	
	private TimerTaskExecutorService timerTaskExecutorService;
	
	@Override
	public void cleanup() throws Throwable {
		
	}

	@Override
	public boolean execute() throws Throwable {
		log.info("开始执行 execute");
		timerTaskExecutorService.execute();
		return true;
	}

	@Override
	public void prepare(JobContext context) throws Throwable {
		ApplicationContext ctx = new SpringApplicationBuilder().sources(JobApplication.class).web(WebApplicationType.NONE).run();
        log.info("hello world test");
        timerTaskExecutorService = ctx.getBean(TimerTaskExecutorService.class);
        log.info("=====>结束运行prepare方法");
	}

}
