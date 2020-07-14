package com.sitech.cntt.fortress.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sitech.cntt.common.HBaseUtil;
import com.sitech.cntt.common.IdmmUtil;
import com.sitech.cntt.fortress.service.DameonTaskExecutorService;
import com.sitech.cntt.inter.SequenceMapper;

/**
 * @author: wujc
 * @date: 2020/6/12
 * @Description: 守护job service实现类
 */
@Service
public class DameonTaskExecutorServiceImpl implements DameonTaskExecutorService {

	Logger log = LogManager.getLogger(DameonTaskExecutorServiceImpl.class);
	
	@Autowired
	private HBaseUtil hBaseUtil;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private IdmmUtil idmmUtil;	
	@Value("${idmm.serverAddress}")
	private String idmmServerAddress;
	@Value("${idmm.clientId}")
	private String idmmClientId;
	@Value("${idmm.topic}")
	private String idmmTopic;
	@Value("${idmm.timeout}")
	private int idmmTimeout;
	
	@Override
	public String fetchData() {
		String message = null;
		try {
			// 消费者从目标主体上订阅信息
			message = idmmUtil.consumer(idmmServerAddress, idmmClientId, idmmTopic, idmmTimeout);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return message;
	}

	@Override
	public void execute(Object input) {
		String message = (String)input;
		try {
			String rowKey = sequenceMapper.getNextVal("SEQ_ROW_KEY").toString();
			log.info("行键："+rowKey);
			hBaseUtil.putData("cntt:baseservice", rowKey, "request", "param", message);
			log.info("表：cntt:basebaseservice，列族：request，列限定符：param，行键："+rowKey+"，值："+message);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}
