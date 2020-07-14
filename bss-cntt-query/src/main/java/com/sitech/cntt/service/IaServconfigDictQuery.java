package com.sitech.cntt.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.sitech.cntt.common.PubReq;

import com.sitech.cntt.inter.IIaServconfigDictQuery;
import com.sitech.cntt.inter.IaServconfigDictMapper;
import com.sitech.cntt.metadata.domain.IaServconfigDict;
import com.sitech.cntt.metadata.domain.IaServconfigDictExample;
import com.sitech.cntt.vo.GetIaServconfigDictByRedisRsp;
import com.sitech.cntt.vo.SelectIaServconfigDictByAppCodeReq;
import com.sitech.cntt.vo.SelectIaServconfigDictByAppCodeRsp;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.wrapper.support.OutDTOBuild;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Service("iaServconfigDictQuerySvc")
@RequestMapping("/servconfig")
@Api(tags = "服务配置查询")
public class IaServconfigDictQuery implements IIaServconfigDictQuery {

	private static final Logger log = LoggerFactory.getLogger(IaServconfigDictQuery.class);
	
	@Value("${cntt.iaservconfigdictlist_redis_key}")
	private String key;
	
	@Autowired
	private IaServconfigDictMapper iaServconfigDictMapper;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
     * @author: wujc
     * @date: 2020/6/22
     * @Description: 根据应用编码查询服务配置列表
     */
	@Override
	@PostMapping("/selectIaServconfigDictByAppCode")
	@ApiOperation(value = "根据应用编码查询服务配置列表")
	public OutDTO<SelectIaServconfigDictByAppCodeRsp> selectIaServconfigDictByAppCode(@RequestBody InDTO<PubReq<SelectIaServconfigDictByAppCodeReq>> inDTO) throws Exception {
		
		log.info("根据应用编码查询服务配置列表入参：" + JSON.toJSONString(inDTO));
		
		SelectIaServconfigDictByAppCodeReq req = Optional.ofNullable(inDTO)
				.flatMap(mapper -> Optional.ofNullable(mapper.getBody()))
				.flatMap(mapper -> Optional.ofNullable(mapper.getBusiInfo()))
				.orElse(null);
		SelectIaServconfigDictByAppCodeRsp rsp = new SelectIaServconfigDictByAppCodeRsp();
		
		if (null == req) {
			throw new Exception("根据应用编码查询服务配置列表入参为空");
		}
		String appCode = req.getAppCode();
		if (StringUtil.isEmptyOrNull(appCode)) {
			throw new Exception("应用编码为空");
		}
		IaServconfigDictExample example = new IaServconfigDictExample();
		IaServconfigDictExample.Criteria criteria = example.createCriteria();
		criteria.andAppCodeEqualTo(appCode);
		List<IaServconfigDict> iaServconfigDictList = iaServconfigDictMapper.selectByExample(example);
		
		log.info("应用编码：" + appCode +",服务列表长度：" + iaServconfigDictList.size());
		
		rsp.setIaServconfigDictList(iaServconfigDictList);
			
		return OutDTOBuild.builder().returnCode("0").returnMsg("根据应用编码查询服务配置列表成功").build(rsp);
	}

	/**
     * @author: wujc
     * @date: 2020/6/29
     * @Description: 从redis获取服务配置列表
     */
	@Override
	@PostMapping("/getIaServconfigDictByRedis")
	@ApiOperation(value = "从redis获取服务配置列表")
	public OutDTO<GetIaServconfigDictByRedisRsp> getIaServconfigDictByRedis() {
		
		GetIaServconfigDictByRedisRsp rsp = new GetIaServconfigDictByRedisRsp();

		List<IaServconfigDict> iaServconfigDictList = (List<IaServconfigDict>) redisTemplate.opsForValue().get(key);
		if (null != iaServconfigDictList && iaServconfigDictList.size()>0) {
			rsp.setIaServconfigDictList(iaServconfigDictList);
		}

		return OutDTOBuild.builder().returnCode("0").returnMsg("从redis获取服务配置列表成功").build(rsp);
	}

}
