package com.sitech.cntt.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PubReq<T> {
	
    @JSONField(name = "OPR_INFO")
    @JsonProperty("OPR_INFO")
    private OprInfo oprInfo;
	
    @JSONField(name = "BUSI_INFO")
    @JsonProperty("BUSI_INFO")
    private T busiInfo;
    
	public OprInfo getOprInfo() {
		return oprInfo;
	}
	public void setOprInfo(OprInfo oprInfo) {
		this.oprInfo = oprInfo;
	}
	public T getBusiInfo() {
		return busiInfo;
	}
	public void setBusiInfo(T busiInfo) {
		this.busiInfo = busiInfo;
	}
    
}
