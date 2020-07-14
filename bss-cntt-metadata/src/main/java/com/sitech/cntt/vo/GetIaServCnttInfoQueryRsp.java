package com.sitech.cntt.vo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sitech.cntt.metadata.domain.ConRel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("根据入参查询出参")
public class GetIaServCnttInfoQueryRsp {
	@ApiModelProperty(value = "交互消息列表")
	@JSONField(name = "CONRELLIST")
	@JsonProperty("CONRELLIST")
	private List<ConRel> conRelList;

	@ApiModelProperty(value = "规模")
	@JSONField(name = "SIZE")
	@JsonProperty("SIZE")
	private int size;
	public List<ConRel> getConRelList() {
		return conRelList;
	}

	public void setConRelList(List<ConRel> conRelList) {
		this.conRelList = conRelList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
