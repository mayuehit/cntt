package com.sitech.cntt.fortress.dataflow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.sitech.cntt.JobApplication;
import com.sitech.cntt.fortress.service.DameonTaskExecutorService;
import com.sitech.fortress.task.DameonTaskExecutor;
import com.sitech.fortress.task.JobContext;

/**
 * @author: wujc
 * @date: 2020/6/12
 * @Description: 守护job，消息信息并存储至hbase
 */
public class DameonTaskExecutorSampleJob implements DameonTaskExecutor{

	Logger log = LogManager.getLogger(DameonTaskExecutorSampleJob.class);
	
	private DameonTaskExecutorService dameonTaskExecutorService;
	
	@Override
	public void cleanup() throws Throwable {
		
	}

	@Override
	public void execute(Object input) throws Throwable {
		log.info("=====>开始运行execute方法");
		dameonTaskExecutorService.execute(input);
		log.info("=====>结束运行execute方法");
	}

	@Override
	public Object fetchData() throws Throwable {
		String message = null;
		message = dameonTaskExecutorService.fetchData();
		return message;
	}

	@Override
	public void prepare(JobContext context) throws Throwable {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new SpringApplicationBuilder().sources(JobApplication.class).web(WebApplicationType.NONE).run();
        log.info("=====>开始运行prepare方法");
        dameonTaskExecutorService = ctx.getBean(DameonTaskExecutorService.class);
        log.info("=====>结束运行prepare方法");
	}

}
