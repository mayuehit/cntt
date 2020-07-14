package com.sitech.cntt.common;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: wujc
 * @date: 2020/6/18
 * @Description: es工具类
 */
@Service
public class EsUtil {
	
	private static final Logger log = LogManager.getLogger(EsUtil.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * @apiNote 根据ID搜索文档
	 * @param esAddress http://ip:port
	 * @param index 索引
	 * @param type 类型
	 * @param id ID
	 * @return JSONObject 
	 */
	public JSONObject searchById(String esAddress, String index, String type, String id) {
		
		String url = esAddress+"/{1}/{2}/{3}"; 
		try {
			ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(url, JSONObject.class, index, type, id);
			if (200 == responseEntity.getStatusCodeValue()) {
				JSONObject result = responseEntity.getBody();
				log.info(result);
				return result;
			}	
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	/**
	 * @apiNote 搜索指定长度的文档
	 * @param esAddress http://ip:port
	 * @param index 索引
	 * @param type 类型
	 * @param size 长度
	 * @return JSONObject 
	 */
	public JSONObject searchBySize(String esAddress, String index, String type, int size) {
		
		String url = esAddress+"/{1}/{2}/_search?size={3}";
		try {
			ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(url, JSONObject.class, index, type, size);
			if (200 == responseEntity.getStatusCodeValue()) {
				JSONObject result = responseEntity.getBody();
				log.info(result);
				return result;
			}
		} catch (Exception e) {
			return null;
		}		
		return null;
	}
	
	/**
	 * @apiNote 不指定ID索引文档
	 * @param esAddress http://ip:port
	 * @param index 索引
	 * @param type 类型
	 * @param jsonObject 文档
	 * @return id
	 */
	public String insert(String esAddress, String index, String type, JSONObject jsonObject) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		String url = esAddress+"/{1}/{2}"; 
		HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject,headers);
		try {
			ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, entity, JSONObject.class, index, type);
			if (201 == responseEntity.getStatusCodeValue()) {
				JSONObject result = responseEntity.getBody();
				log.info(result);
				return Optional.ofNullable(result)
						.flatMap(mapper -> Optional.ofNullable(mapper.getString("_id")))
						.orElse(null);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	/**
	 * @apiNote 指定ID索引文档/重新索引文档
	 * @param esAddress http://ip:port
	 * @param index 索引
	 * @param type 类型
	 * @param id
	 * @param jsonObject 文档
	 * @return boolean
	 */
	public boolean insertById(String esAddress, String index, String type, String id, JSONObject jsonObject) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		String url = esAddress+"/{1}/{2}/{3}"; 
		HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject,headers);
		try {
			ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, JSONObject.class, index, type, id);
			if (200 == responseEntity.getStatusCodeValue() || 201 == responseEntity.getStatusCodeValue()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	/**
	 * @apiNote 指定ID删除文档
	 * @param esAddress http://ip:port
	 * @param index 索引
	 * @param type 类型
	 * @param id
	 * @return boolean
	 */
	public boolean deleteById(String esAddress, String index, String type, String id) {
		
		String url = esAddress+"/{1}/{2}/{3}"; 
		try {
			ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, JSONObject.class, index, type, id);
			if (200 == responseEntity.getStatusCodeValue()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}		
		return false;
	}
	
}
