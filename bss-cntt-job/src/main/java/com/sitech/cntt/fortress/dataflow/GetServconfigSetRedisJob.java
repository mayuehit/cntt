package com.sitech.cntt.fortress.dataflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.sitech.cntt.JobApplication;
import com.sitech.cntt.fortress.service.GetServconfigSetRedisService;
import com.sitech.fortress.task.JobContext;
import com.sitech.fortress.task.TimerTaskExecutor;

/**
 * @author: wujc
 * @date: 2020/6/29
 * @Description: 定时job,查询服务配置信息列表存储至redis
 */
public class GetServconfigSetRedisJob implements TimerTaskExecutor {

	private static final Logger log = LoggerFactory.getLogger(GetServconfigSetRedisJob.class);
	private GetServconfigSetRedisService getServconfigSetRedisService;
	
	@Override
	public void cleanup() throws Throwable {
		
	}

	@Override
	public boolean execute() throws Throwable {
		log.info("查询服务配置信息列表存储至redis定时任务execute--start");
		getServconfigSetRedisService.execute();
		log.info("查询服务配置信息列表存储至redis定时任务execute--end");
		return true;
	}

	@Override
	public void prepare(JobContext context) throws Throwable {
		ApplicationContext ctx = new SpringApplicationBuilder().sources(JobApplication.class).web(WebApplicationType.NONE).run();
        log.info("查询服务配置信息列表存储至redis定时任务prepare--start");
        getServconfigSetRedisService = ctx.getBean(GetServconfigSetRedisService.class);
        log.info("查询服务配置信息列表存储至redis定时任务prepare--end");
	}

}
