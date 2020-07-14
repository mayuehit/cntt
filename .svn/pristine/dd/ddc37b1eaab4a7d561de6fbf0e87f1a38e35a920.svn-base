package com.sitech.cntt;

import com.sitech.fortress.worker.WorkerEnvExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: wujc
 * @date: 2020/6/3
 * @Description: worker启动类
 */
@Component
public class WorkerEnvExecutorSample implements WorkerEnvExecutor {
    private static Logger log = LoggerFactory.getLogger(WorkerEnvExecutorSample.class);

    @Override
    public void prepare(Map<Object, Object> conf, String projectId, String arg) {

        ApplicationContext ctx = new SpringApplicationBuilder().sources(JobApplication.class).web(WebApplicationType.NONE).run();
    }

    @Override
    public void cleanup() {
        log.info("WorkerEnvExecutorSample call cleanup ...");
    }







    public static void main(String[] args) {
//        String conditonType = "ALL";
//        int sleepTime = 10;
//
//        SpringBeanFactory springBeanFactory = new SpringBeanFactory(new String[]{"processContext.xml"});
//        //DealBusiInterface dealBusiInterface = (DealBusiInterface) springBeanFactory.getBean("dealBusiInterface");
//        LOG.info("====>容器启动成功");
//        LOG.info("==========================================loadCache begin===================================");
        ApplicationContext ctx = new SpringApplicationBuilder().sources(JobApplication.class).web(WebApplicationType.NONE).run();

        String[] beanNames = ctx.getBeanDefinitionNames();
        log.info("bean总数:{}", ctx.getBeanDefinitionCount());
        int i = 0;
        for (String str : beanNames) {
            log.debug("{},beanName:{}", ++i, str);
        }

        log.info("=== WorkerEnvExecutor prepare end ===");
    }
}