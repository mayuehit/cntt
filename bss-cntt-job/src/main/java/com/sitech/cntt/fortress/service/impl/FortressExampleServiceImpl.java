package com.sitech.cntt.fortress.service.impl;

import com.sitech.cntt.constant.FortressJobConst;
import com.sitech.cntt.fortress.service.FortressExampleService;
import com.sitech.cntt.inter.FortressTestMapper;
import com.sitech.cntt.metadata.domain.FortressTest;
import com.sitech.cntt.metadata.domain.FortressTestExample;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: wujc
 * @date: 2020/6/3
 * @Description: 守护job样例service实现类
 */
@Service
public class FortressExampleServiceImpl implements FortressExampleService {
    Logger log = LogManager.getLogger(FortressExampleServiceImpl.class);
    @Autowired
    private FortressTestMapper fortressTestMapper;
    @Value("${job.FortressTest.limitSize}")
    private String limitSize;

    @Override
    public int updateDspList(int shardCount, int shardItem, String taskId) {

        log.info("33333333333");
        Map<String, Object> inMap = new HashMap<>();

        String ip = "";
        try {
            InetAddress localHost = Inet4Address.getLocalHost();
            ip = localHost.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int num = 0;
        log.info("-------------------fortress example Job start----------------");

        //获取数据，调用自定义的方法
        inMap.put("statusCd", FortressJobConst.TableStatusConst.STATUS_CD_1000);
        inMap.put("limitSize", limitSize);
        inMap.put("shardCount", shardCount);
        inMap.put("shardCurrent", shardItem);
        inMap.put("dspStatus", FortressJobConst.FortressConst.DSP_STATUS_0);


        log.info("查询sql条件 " + inMap);
        List<FortressTest> fortressTestList = fortressTestMapper.qryDataByMap(inMap);
        log.info("查询结果list =" + fortressTestList.size());
        if (fortressTestList.size() > 0 && null != fortressTestList) {
//            fortressTestList.forEach(fortressTest ->
            for (FortressTest fortressTest : fortressTestList) {
                //按照fortress要求赋值
                //DSP_STATUS为1表示锁定或正在处理
                fortressTest.setDspStatus(FortressJobConst.FortressConst.DSP_STATUS_1);
                //DSP_ACCEPT为本批次流水
                fortressTest.setDspAccept(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
                //DSP_POSITION记录是处理的主机信息，此类中存储是ip+taskId
                fortressTest.setDspPosition(ip + taskId);
                //DSP_UPDATE_TIME为修改时间
                fortressTest.setDspUpdateTime(new Date());
                fortressTestMapper.updateFortressStatus(fortressTest);
                num++;
            }
        }
        log.info("======>第" + shardItem + "个线程一共锁定数据的总量为：" + num);
        return num;
    }

    @Override
    public List<Object> qryDspList(int shardCount, int shardItem, String status) {
        List<Object> retList = new ArrayList<>();
        Map<String,Object> inMap = new HashMap<String,Object>();
        inMap.put("dspStatus", status);
        inMap.put("limitSize", limitSize);
        inMap.put("shardCount", shardCount);
        inMap.put("shardCurrent", shardItem);
        List<FortressTest> fortressTestList = fortressTestMapper.qryDataByMap(inMap);
        log.info("======>第" + shardItem + "个线程一共查询到锁定数据的总量为：" + fortressTestList.size());
        if( null != fortressTestList && fortressTestList.size() > 0 ){
            //循环赋值
            for( FortressTest fortressTest : fortressTestList ){
                retList.add(fortressTest);
            }
        }
        log.info("qryDspList 执行结束,返回数量" + retList.size());
        return retList;
    }

    @Override
    public void executeBusi(Object input) {

        log.info("执行到 xxxx了");
        //类型强转
        FortressTest fortressTest = new FortressTest();
        try {
            fortressTest = (FortressTest) input;
        } catch (Exception e) {
            log.error("类型转换错误");
        }

        //重声明一个对象， 目的是更新指定的字段
        log.info("开始job的更新操作");
        FortressTest upFortressTest = new FortressTest();
        upFortressTest.setRemark("job更新");
        upFortressTest.setStatusCd(FortressJobConst.TableStatusConst.STATUS_CD_1100);
        upFortressTest.setStatusDate(new Date());
        upFortressTest.setAccept(fortressTest.getAccept());
        if (StringUtils.isNotEmpty(upFortressTest.getAccept())) {
            fortressTestMapper.updateByPrimaryKeySelective(upFortressTest);
        }
    }

    @Override
    public void updateDspByKey(Object input) {
        log.info("Fortress更新状态，状态更新为2，处理完成");
        //类型强转
        FortressTest fortressTest = new FortressTest();
        try {
            fortressTest = (FortressTest) input;
        } catch (Exception e) {
            log.error("fortress状态更新类型转换错误");
        }


        //此方法是executeBusi方法，每执行一条语句完成后就会调该方法，而不是批量的，可以直接用该对象更新
        FortressTestExample fortressTestExample = new FortressTestExample();
        fortressTestExample.createCriteria().andAcceptEqualTo(fortressTest.getAccept());
        List<FortressTest> fortressTestList = fortressTestMapper.selectByExample(fortressTestExample);
        if (fortressTestList.size() > 0 && null != fortressTestList) {
            for (FortressTest fortressTestTmp : fortressTestList) {
                FortressTest UpFortressTest = new FortressTest();
                UpFortressTest.setDspStatus(FortressJobConst.FortressConst.DSP_STATUS_2);
                UpFortressTest.setDspUpdateTime(new Date());
                UpFortressTest.setAccept(fortressTestTmp.getAccept());
                fortressTestMapper.updateFortressStatus(UpFortressTest);
            }
        }
    }

}
