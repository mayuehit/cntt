package com.sitech.cntt.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: wujc
 * @date: 2020/6/22
 * @Description: 根据应用编码查询服务配置列表入参
 */
@ApiModel(value = "根据应用编码查询服务配置列表入参")
public class SelectIaServconfigDictByAppCodeReq {
	
	@ApiModelProperty(value = "应用编码")
	@JSONField(name = "APP_CODE")
	@JsonProperty("APP_CODE")
	private String appCode;
	
	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	
}
