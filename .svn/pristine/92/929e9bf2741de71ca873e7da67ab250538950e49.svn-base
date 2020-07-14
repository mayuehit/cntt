package com.sitech.cntt.common;

import java.util.Random;

import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sitech.crmpd.idmm.client.MessageContext;
import com.sitech.crmpd.idmm.client.api.Message;
import com.sitech.crmpd.idmm.client.api.PropertyOption;
import com.sitech.crmpd.idmm.client.api.PullCode;
import com.sitech.crmpd.idmm.client.api.ResultCode;
import com.sitech.crmpd.idmm.client.pool.PooledMessageContextFactory;

/**
 * @author: wujc
 * @date: 2020/6/19
 * @Description: idmm工具类
 */
@Service
public class IdmmUtil {
	
	private static final Logger log = LogManager.getLogger(IdmmUtil.class);
	
	// 生产者
 	public void producer(String serverAddress, String clientId, String topic, int timeout, String content) throws Exception{
 		
 		// 创建连接池对象
         final GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
         config.setTestOnBorrow(true);
         final KeyedObjectPool<String, MessageContext> pool = new GenericKeyedObjectPool<String, MessageContext>(
                 new PooledMessageContextFactory(serverAddress, timeout), config);
         
         MessageContext context = null;
         Random random = new Random(100000000L);
         try {
         	// 获取连接MessageConText
             context = pool.borrowObject(clientId);
             // 消息创建
             final Message message = Message.create(content);
             // 设置消息属性
             message.setProperty(PropertyOption.GROUP, Math.abs(random.nextInt()) + "");
             // 设置自定义的消息属性，测试主题映射等
//	           PropertyOption<Object> CUSTOM_KEY = PropertyOption.valueOf("key");
//	           message.setProperty(CUSTOM_KEY, "2");

             // 发送消息
             final String msgid = context.send(topic, message);
             
             // 处理本地事务
             log.info(("发送  消息id:[" + msgid + "],内容:["+content+"]"));

             // 提交消息
             context.commit(msgid);
             
             // 提交本地事务
             log.info("提交完成");
         } catch (final Exception e) {
             e.printStackTrace();
         } finally {
             if (context != null) {
                 try {
                 	// 释放连接
                     pool.returnObject(clientId, context);
                 } catch (final Exception e) {
                 }
             }
         }
 	}
 	
 	// 消费者
 	public String consumer(String serverAddress, String clientId, String topic, int timeout) throws Exception{
 		
 		// 创建连接池对象
         final GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
         config.setTestOnBorrow(true);
         final KeyedObjectPool<String, MessageContext> pool = new GenericKeyedObjectPool<String, MessageContext>(
                 new PooledMessageContextFactory(serverAddress, timeout), config);
         
         // 上一消息id
         String lastMessageId = null;
         // 上一消息的处理结果
         PullCode code = null;
         // 上一消息的处理结果描述
         String description = "消费成功";
         // 一个消息的预期最大处理时间，单位秒
         final long processingTime = 60L;
         
         MessageContext context = null;
         
         String result = null;
 	     
         try {
         	// 获取连接MessageConText
             context = pool.borrowObject(clientId);
             // 获取消息(阻塞式)
             final Message message = context.fetch(topic, processingTime, lastMessageId, code,
                     description, false);
             // 获取结果码
             final ResultCode resultCode = ResultCode.valueOf(message
                     .getProperty(PropertyOption.RESULT_CODE));
             // 判断是否存在该订阅主题或消息
             if (resultCode == ResultCode.NO_MORE_MESSAGE) {
             	log.info("没有更多消息");
             } else {
             	// 获取消息ID，为便于调试，请将获取的消息ID输出至日志
                 lastMessageId = message.getId();
                 // 获取消息内容
                 final String content = message.getContentAsString();

                 // 处理本地事务
                 log.info(("消息ID:["+lastMessageId+"],消息内容:["+content+"]"));

                 // 为保证无论消息处理的是否成功均能反馈消息处理结果，请务必给code赋值
                 code = PullCode.COMMIT_AND_NEXT;

                 // 提交本地事务:消费消息
                 result = content;
                 context.fetch(topic, processingTime, lastMessageId, code,
                         description, false);
                 log.info("消费成功");
 			}           
         } catch (final Exception e) {
         	log.info(e.getMessage());
         } finally {
             if (context != null) {
                 try {
                 	// 释放连接
                     pool.returnObject(clientId, context);
                 } catch (final Exception e) {
                 }
             }
         }
         return result;
 	}
}
