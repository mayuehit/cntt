package com.sitech.cntt.fortress.service;

import java.util.List;

/**
 * @author: wujc
 * @date: 2020/6/3
 * @Description: 守护job样例service
 */
public interface FortressExampleService {
    /**
     * 取得一批要处理的数据，将这些数据状态锁定并记录修改流水和时间
     * @param taskId
     * @return
     */
    public int updateDspList(int shardCount, int shardItem, String taskId);


    /**
     * 查询被锁定的表，框架会自动调用qryDspList方法，该方法要根DSP_STATUS为1查询出上步锁定的数据，封装成list对象
     * @param shardCount
     * @param shardItem
     * @param status
     * @return
     */
    public List<Object> qryDspList(int shardCount, int shardItem, String status);


    /**
     * 查询得到的数据列表，循环调用executeBusi方法，该方法将执行业务类
     * @param input
     */
    public void executeBusi(Object input);

    /**
     * 将已执行完的数据状态修改为已完成。修改DSP_STATUS为2.
     * @param input
     */
    public void updateDspByKey(Object input);

}
