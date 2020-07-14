package com.sitech.cntt.fortress.dataflow;

import com.sitech.cntt.JobApplication;
import com.sitech.cntt.constant.FortressJobConst;
import com.sitech.cntt.fortress.service.FortressExampleService;
import com.sitech.fortress.client.TableTaskBase;
import com.sitech.fortress.task.JobContext;
import com.sitech.jcf.ijdbc.util.DataSourceUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: wujc
 * @date: 2020/6/3
 * @Description: 守护job样例，处理关系型数据库数据
 */
public class FortressExampleJob extends TableTaskBase {

    Logger log = LogManager.getLogger(FortressExampleJob.class);

    private FortressExampleService fortressExampleService;

    //分区总数
    private int partionNum = 0;
    //分区开始位置
    private String beginPartion = "";
    //分区结束位置
    private String endPartion = "";

    //数据库
    DataSource ds = DataSourceUtils.getDefaultDataSource();


    public FortressExampleJob() throws UnknownHostException {
    }

    /**
     * 1.初始化
     *
     * @param context
     */
    @Override
    public void prepare(JobContext context) {
        DataSource ds = DataSourceUtils.getDefaultDataSource();
        try {
            log.info("获取数据库");
            conn = ds.getConnection();
        } catch (SQLException e) {
            log.error("数据库获取失败");
            e.printStackTrace();
        }
        partionNum = context.getJobInfo().getPartionNum();
        log.info("=====>partionNum的值为" + partionNum);

        beginPartion = context.getTaskInfo().getBeginPartion();
        log.info("=====>beginPartion的值为" + beginPartion);

        endPartion = context.getTaskInfo().getEndPartion();
        log.info("=====>endPartion的值为" + endPartion);
        taskId = context.getTaskId();
        log.info("=====>开始运行prepare方法");
        //在这里只能用getBean的方法获得业务层的bean
        //fortressExampleService = (FortressExampleServiceImpl) SpringUtils.getBean("fortressExampleServiceImpl");
        ApplicationContext ctx = new SpringApplicationBuilder().sources(JobApplication.class).web(WebApplicationType.NONE).run();
        log.info("hello world test");
        fortressExampleService = ctx.getBean(FortressExampleService.class);

        log.info("=====>结束运行prepare方法");
    }
    
    /**
     * 2.取得一批要处理的数据，将这些数据状态锁定并记录修改流水和时间
     *
     * @param object
     * @return
     */
    @Override
    protected int updateDspList(Map<String, Object> object) {

        log.info("执行到这里了 updateDspList " + "partionNum:" + partionNum + "  beginPartion:" + beginPartion + "  taskId" + taskId);
        return fortressExampleService.updateDspList(partionNum, Integer.parseInt(beginPartion), taskId);
    }

    /**
     * 3.查询被锁定的表，框架会自动调用qryDspList方法，该方法要根DSP_STATUS为1查询出上步锁定的数据，封装成list对象
     *
     * @param object
     * @return
     */
    @Override
    protected List<Object> qryDspList(Map<String, Object> object) {
        List<Object> retList = new ArrayList<>();
        try {
            retList = fortressExampleService.qryDspList(partionNum, Integer.parseInt(beginPartion), FortressJobConst.FortressConst.DSP_STATUS_1);
            log.info("Fortress qryDspList 返回list大小为 " + retList.size());
            conn.commit();
        } catch (SQLException e) {
            log.error("qryDspList 获取数据错误");
            e.printStackTrace();
        }
        return retList;
    }

    /**
     * 4.查询得到的数据列表，循环调用executeBusi方法，该方法将执行业务类
     *
     * @param input
     */
    @Override
    protected void executeBusi(Object input) {
        log.info("开始执行 executeBusi");
        fortressExampleService.executeBusi(input);
    }

    /**
     * 5.将已执行完的数据状态修改为已完成。修改DSP_STATUS为2.
     *
     * @param input
     */
    @Override
    protected void updateDspByKey(Object input) {
        /*
         * 在实际业务场景有很多扫表处理后业务数据就被删除，移到别的表里去，
         * 所以该方法是可以为空，什么也不执行，但该方法不可以删除。
         * 如果需要修改状态为2则需要业务根据情况写相应的修改语句。
         * 注意：该方法是在第四步每执行一条语句完成后就会调该方法，而不是批量的。
         * */
        fortressExampleService.updateDspByKey(input);

    }

    @Override
    public void cleanup() {

    }
}
