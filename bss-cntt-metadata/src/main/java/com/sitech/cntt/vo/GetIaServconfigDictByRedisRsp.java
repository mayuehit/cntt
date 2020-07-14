package com.sitech.cntt.vo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sitech.cntt.metadata.domain.IaServconfigDict;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: wujc
 * @date: 2020/6/29
 * @Description: 从redis获取服务配置列表出参
 */
@ApiModel(value = "从redis获取服务配置列表出参")
public class GetIaServconfigDictByRedisRsp {
	@ApiModelProperty(value = "服务配置列表")
	@JSONField(name = "IA_SERVCONFIG_DICT_LIST")
	@JsonProperty("IA_SERVCONFIG_DICT_LIST")
	private List<IaServconfigDict> iaServconfigDictList;

	public List<IaServconfigDict> getIaServconfigDictList() {
		return iaServconfigDictList;
	}

	public void setIaServconfigDictList(List<IaServconfigDict> iaServconfigDictList) {
		this.iaServconfigDictList = iaServconfigDictList;
	}
}
