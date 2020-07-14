package com.sitech.cntt.metadata.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wujc
 * @date: 2020/7/8
 */
@ApiModel(value = "接触服务日志记录")
public class IaContactservlogRd implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "接触流水")
	@JSONField(name = "CONTACT_ACCEPT")
	@JsonProperty("CONTACT_ACCEPT")
	private String contactAccept;
	
	@ApiModelProperty(value = "接触ID")
	@JSONField(name = "CONTACT_ID")
	@JsonProperty("CONTACT_ID")
	private String contactId;
	
	@ApiModelProperty(value = "接触状态")
	@JSONField(name = "CONTACT_STATUS")
	@JsonProperty("CONTACT_STATUS")
	private String contactStatus;
	
	@ApiModelProperty(value = "IP地址")
	@JSONField(name = "IP_ADDR")
	@JsonProperty("IP_ADDR")
	private String ipAddr;
	
	@ApiModelProperty(value = "工号归属地市")
	@JSONField(name = "LOGIN_GROUP_ID")
	@JsonProperty("LOGIN_GROUP_ID")
	private String loginGroupId;
	
	@ApiModelProperty(value = "工号")
	@JSONField(name = "LOGIN_NO")
	@JsonProperty("LOGIN_NO")
	private String loginNo;
	
	@ApiModelProperty(value = "工号名称")
	@JSONField(name = "LOGIN_NAME")
	@JsonProperty("LOGIN_NAME")
	private String loginName;
	
	@ApiModelProperty(value = "操作时间")
	@JSONField(name = "OP_TIME")
	@JsonProperty("OP_TIME")
	private String opTime;
	
	@ApiModelProperty(value = "操作日期")
	@JSONField(name = "TOTAL_DATE")
	@JsonProperty("TOTAL_DATE")
	private String totalDate;
	
	@ApiModelProperty(value = "渠道标示")
	@JSONField(name = "CLASS_CODE")
	@JsonProperty("CLASS_CODE")
	private String classCode;
	
	@ApiModelProperty(value = "认证方式之间使用|分隔，前后都使用|")
	@JSONField(name = "AUTHEN_CODE")
	@JsonProperty("AUTHEN_CODE")
	private String authenCode;
	
	@ApiModelProperty(value = "会话id")
	@JSONField(name = "SESSION_ID")
	@JsonProperty("SESSION_ID")
	private String sessionId;
	
	@ApiModelProperty(value = "4A主帐号")
	@JSONField(name = "SESSION_ACCOUNT")
	@JsonProperty("SESSION_ACCOUNT")
	private String sessionAccount;
	
	@ApiModelProperty(value = "是否绕行")
	@JSONField(name = "IS_PASS")
	@JsonProperty("IS_PASS")
	private String isPass;
	
	@ApiModelProperty(value = "目的IP")
	@JSONField(name = "AIM_IP")
	@JsonProperty("AIM_IP")
	private String aimIp;
	
	@ApiModelProperty(value = "目的端口")
	@JSONField(name = "AIM_PORT")
	@JsonProperty("AIM_PORT")
	private String aimPort;
	
	@ApiModelProperty(value = "源端口")
	@JSONField(name = "START_PORT")
	@JsonProperty("START_PORT")
	private String startPort;
	
	@ApiModelProperty(value = "应用名称")
	@JSONField(name = "APPLY_NAME")
	@JsonProperty("APPLY_NAME")
	private String applyName;
	
	@ApiModelProperty(value = "应用编码")
	@JSONField(name = "APPLY_CODE")
	@JsonProperty("APPLY_CODE")
	private String applyCode;
	
	@ApiModelProperty(value = "事件所属系统名称")
	@JSONField(name = "SYS_NAME")
	@JsonProperty("SYS_NAME")
	private String sysName;
	
	@ApiModelProperty(value = "在weblogic部署时配置静态参数 营业配置值为'BUSIOPR'互联网渠道配置为'INTERNET';前台登录时把此变量加载到session,业务提交时把此变量添加到COMMON节点下传给后台")
	@JSONField(name = "CHANNEL_ID")
	@JsonProperty("CHANNEL_ID")
	private String channelId;
	
	@ApiModelProperty(value = "工号归属地市名")
	@JSONField(name = "LOGIN_GROUP_NAME")
	@JsonProperty("LOGIN_GROUP_NAME")
	private String loginGroupName;
	
	@ApiModelProperty(value = "认证方式")
	@JSONField(name = "AUTHEN_NAME")
	@JsonProperty("AUTHEN_NAME")
	private String authenName;
	
	@ApiModelProperty(value = "渠道名称")
	@JSONField(name = "CHANNEL_NAME")
	@JsonProperty("CHANNEL_NAME")
	private String channelName;
	
	@ApiModelProperty(value = "渠道名称")
	@JSONField(name = "CLASS_NAME")
	@JsonProperty("CLASS_NAME")
	private String className;
	
	@ApiModelProperty(value = "地市标示")
	@JSONField(name = "REGION_ID")
	@JsonProperty("REGION_ID")
	private String regionId;
	
	@ApiModelProperty(value = "渠道类型")
	@JSONField(name = "CHANNEL_TYPE")
	@JsonProperty("CHANNEL_TYPE")
	private String channelType;
	
	@ApiModelProperty(value = "固定拼，工号于*TOTAL_DATE*时间办理了*OP_NAME*业务")
	@JSONField(name = "OP_NOTE_4A")
	@JsonProperty("OP_NOTE_4A")
	private String opNote4A;
	
	@ApiModelProperty(value = "4A服务号码")
	@JSONField(name = "PHONE_NO_4A")
	@JsonProperty("PHONE_NO_4A")
	private String phoneNo4A;
	
	@ApiModelProperty(value = "4A金库流水")
	@JSONField(name = "BANK_ACCEPT_4A")
	@JsonProperty("BANK_ACCEPT_4A")
	private String bankAccept4A;
	
	@ApiModelProperty(value = "4A")
	@JSONField(name = "RET_CODE_4A")
	@JsonProperty("RET_CODE_4A")
	private String retCode4A;
	
	@ApiModelProperty(value = "4A")
	@JSONField(name = "RET_MSG_4A")
	@JsonProperty("RET_MSG_4A")
	private String retMsg4A;
	
	@ApiModelProperty(value = "是否继续业务标识 Y --是 N--否")
	@JSONField(name = "BUSI_FLAG_4A")
	@JsonProperty("BUSI_FLAG_4A")
	private String busiFlag4A;
	
	@ApiModelProperty(value = "超时标识，0--报错 1--成功")
	@JSONField(name = "TIMEOUT_FLAG_4A")
	@JsonProperty("TIMEOUT_FLAG_4A")
	private String timeoutFlag4A;
	
	@ApiModelProperty(value = "默认Y")
	@JSONField(name = "SEV_NAME_4A")
	@JsonProperty("SEV_NAME_4A")
	private String serName4A;
	
	@ApiModelProperty(value = "接口名称")
	@JSONField(name = "INTERCODE")
	@JsonProperty("INTERCODE")
	private String intercode;
	
	@ApiModelProperty(value = "接口中文名称")
	@JSONField(name = "INTERNAME")
	@JsonProperty("INTERNAME")
	private String intername;
	
	@ApiModelProperty(value = "操作流水")
	@JSONField(name = "OP_ACCEPT")
	@JsonProperty("OP_ACCEPT")
	private String opAccept;
	
	@ApiModelProperty(value = "在客服中相当于受理号码")
	@JSONField(name = "PHONE_NO")
	@JsonProperty("PHONE_NO")
	private String phoneNo;
	
	@ApiModelProperty(value = "用户归属")
	@JSONField(name = "USER_GROUP_ID")
	@JsonProperty("USER_GROUP_ID")
	private String userGroupId;
	
	@ApiModelProperty(value = "用户归属组织名称")
	@JSONField(name = "USER_GROUP_NAME")
	@JsonProperty("USER_GROUP_NAME")
	private String userGroupName;
	
	@ApiModelProperty(value = "订单号")
	@JSONField(name = "ORDER_ID")
	@JsonProperty("ORDER_ID")
	private String orderId;
	
	@ApiModelProperty(value = "子订单号")
	@JSONField(name = "SUB_ORDER_ID")
	@JsonProperty("SUB_ORDER_ID")
	private String subOrderId;
	
	@ApiModelProperty(value = "订单状态")
	@JSONField(name = "ORDER_STATUS")
	@JsonProperty("ORDER_STATUS")
	private String orderStatus;
	
	@ApiModelProperty(value = "操作代码")
	@JSONField(name = "OP_CODE")
	@JsonProperty("OP_CODE")
	private String opCode;
	
	@ApiModelProperty(value = "系统备注")
	@JSONField(name = "SYSTEM_NOTE")
	@JsonProperty("SYSTEM_NOTE")
	private String systemNote;
	
	@ApiModelProperty(value = "品牌")
	@JSONField(name = "BRAND_ID")
	@JsonProperty("BRAND_ID")
	private String brandId;
	
	@ApiModelProperty(value = "客以客户为中心，办理业务。查询订单时，要求可以按照客户信息查询客户订单")
	@JSONField(name = "CUST_ID")
	@JsonProperty("CUST_ID")
	private String custId;
	
	@ApiModelProperty(value = "主服务号码")
	@JSONField(name = "MASTER_SERV_ID")
	@JsonProperty("MASTER_SERV_ID")
	private String masterServId;
	
	@ApiModelProperty(value = "主产品实例ID")
	@JSONField(name = "ID_NO")
	@JsonProperty("ID_NO")
	private String idNo;
	
	@ApiModelProperty(value = "操作备注")
	@JSONField(name = "OP_NOTE")
	@JsonProperty("OP_NOTE")
	private String opNote;
	
	@ApiModelProperty(value = "ia_custidtype_dict配置在这个里面")
	@JSONField(name = "CUST_ID_TYPE")
	@JsonProperty("CUST_ID_TYPE")
	private String custIdType;
	
	@ApiModelProperty(value = "功能名称")
	@JSONField(name = "FUNCTION_NAME")
	@JsonProperty("FUNCTION_NAME")
	private String functionName;
	
	@ApiModelProperty(value = "主服务ID")
	@JSONField(name = "MASTER_SERV_NAME")
	@JsonProperty("MASTER_SERV_NAME")
	private String masterServName;
	
	@ApiModelProperty(value = "品牌名称")
	@JSONField(name = "BRAND_NAME")
	@JsonProperty("BRAND_NAME")
	private String brandName;
	
	@ApiModelProperty(value = "担保人客户标识")
	@JSONField(name = "ASSURE_CUST_ID")
	@JsonProperty("ASSURE_CUST_ID")
	private String assureCustId;
	
	@ApiModelProperty(value = "推荐人工号")
	@JSONField(name = "REF_LOGIN_NO")
	@JsonProperty("REF_LOGIN_NO")
	private String refLoginNo;
	
	@ApiModelProperty(value = "票号 发票或者免填单号")
	@JSONField(name = "BILL_ID")
	@JsonProperty("BILL_ID")
	private String billId;
	
	@ApiModelProperty(value = "鹰眼使用")
	@JSONField(name = "TRACE_ID")
	@JsonProperty("TRACE_ID")
	private String traceId;
	
	@ApiModelProperty(value = "费用金额")
	@JSONField(name = "TOTAL_FEE")
	@JsonProperty("TOTAL_FEE")
	private String totalFee;
	
	@ApiModelProperty(value = "是否涉敏")
	@JSONField(name = "SUSFLAG")
	@JsonProperty("SUSFLAG")
	private String susflag;
	
	@ApiModelProperty(value = "客户信息模糊化")
	@JSONField(name = "DIMFLAG")
	@JsonProperty("DIMFLAG")
	private String dimflag;
	
	@ApiModelProperty(value = "查询条件")
	@JSONField(name = "QRY_CONDITION")
	@JsonProperty("QRY_CONDITION")
	private String qryCondition;

	public String getContactAccept() {
		return contactAccept;
	}

	public void setContactAccept(String contactAccept) {
		this.contactAccept = contactAccept;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getContactStatus() {
		return contactStatus;
	}

	public void setContactStatus(String contactStatus) {
		this.contactStatus = contactStatus;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getLoginGroupId() {
		return loginGroupId;
	}

	public void setLoginGroupId(String loginGroupId) {
		this.loginGroupId = loginGroupId;
	}

	public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getOpTime() {
		return opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getTotalDate() {
		return totalDate;
	}

	public void setTotalDate(String totalDate) {
		this.totalDate = totalDate;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getAuthenCode() {
		return authenCode;
	}

	public void setAuthenCode(String authenCode) {
		this.authenCode = authenCode;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionAccount() {
		return sessionAccount;
	}

	public void setSessionAccount(String sessionAccount) {
		this.sessionAccount = sessionAccount;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public String getAimIp() {
		return aimIp;
	}

	public void setAimIp(String aimIp) {
		this.aimIp = aimIp;
	}

	public String getAimPort() {
		return aimPort;
	}

	public void setAimPort(String aimPort) {
		this.aimPort = aimPort;
	}

	public String getStartPort() {
		return startPort;
	}

	public void setStartPort(String startPort) {
		this.startPort = startPort;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getLoginGroupName() {
		return loginGroupName;
	}

	public void setLoginGroupName(String loginGroupName) {
		this.loginGroupName = loginGroupName;
	}

	public String getAuthenName() {
		return authenName;
	}

	public void setAuthenName(String authenName) {
		this.authenName = authenName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getOpNote4A() {
		return opNote4A;
	}

	public void setOpNote4A(String opNote4A) {
		this.opNote4A = opNote4A;
	}

	public String getPhoneNo4A() {
		return phoneNo4A;
	}

	public void setPhoneNo4A(String phoneNo4A) {
		this.phoneNo4A = phoneNo4A;
	}

	public String getBankAccept4A() {
		return bankAccept4A;
	}

	public void setBankAccept4A(String bankAccept4A) {
		this.bankAccept4A = bankAccept4A;
	}

	public String getRetCode4A() {
		return retCode4A;
	}

	public void setRetCode4A(String retCode4A) {
		this.retCode4A = retCode4A;
	}

	public String getRetMsg4A() {
		return retMsg4A;
	}

	public void setRetMsg4A(String retMsg4A) {
		this.retMsg4A = retMsg4A;
	}

	public String getBusiFlag4A() {
		return busiFlag4A;
	}

	public void setBusiFlag4A(String busiFlag4A) {
		this.busiFlag4A = busiFlag4A;
	}

	public String getTimeoutFlag4A() {
		return timeoutFlag4A;
	}

	public void setTimeoutFlag4A(String timeoutFlag4A) {
		this.timeoutFlag4A = timeoutFlag4A;
	}

	public String getSerName4A() {
		return serName4A;
	}

	public void setSerName4A(String serName4A) {
		this.serName4A = serName4A;
	}

	public String getIntercode() {
		return intercode;
	}

	public void setIntercode(String intercode) {
		this.intercode = intercode;
	}

	public String getIntername() {
		return intername;
	}

	public void setIntername(String intername) {
		this.intername = intername;
	}

	public String getOpAccept() {
		return opAccept;
	}

	public void setOpAccept(String opAccept) {
		this.opAccept = opAccept;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSubOrderId() {
		return subOrderId;
	}

	public void setSubOrderId(String subOrderId) {
		this.subOrderId = subOrderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getSystemNote() {
		return systemNote;
	}

	public void setSystemNote(String systemNote) {
		this.systemNote = systemNote;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getMasterServId() {
		return masterServId;
	}

	public void setMasterServId(String masterServId) {
		this.masterServId = masterServId;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getOpNote() {
		return opNote;
	}

	public void setOpNote(String opNote) {
		this.opNote = opNote;
	}

	public String getCustIdType() {
		return custIdType;
	}

	public void setCustIdType(String custIdType) {
		this.custIdType = custIdType;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getMasterServName() {
		return masterServName;
	}

	public void setMasterServName(String masterServName) {
		this.masterServName = masterServName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getAssureCustId() {
		return assureCustId;
	}

	public void setAssureCustId(String assureCustId) {
		this.assureCustId = assureCustId;
	}

	public String getRefLoginNo() {
		return refLoginNo;
	}

	public void setRefLoginNo(String refLoginNo) {
		this.refLoginNo = refLoginNo;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getSusflag() {
		return susflag;
	}

	public void setSusflag(String susflag) {
		this.susflag = susflag;
	}

	public String getDimflag() {
		return dimflag;
	}

	public void setDimflag(String dimflag) {
		this.dimflag = dimflag;
	}

	public String getQryCondition() {
		return qryCondition;
	}

	public void setQryCondition(String qryCondition) {
		this.qryCondition = qryCondition;
	}

}
