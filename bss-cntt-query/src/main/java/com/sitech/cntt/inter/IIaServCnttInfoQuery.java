package com.sitech.cntt.inter;


import com.sitech.cntt.common.PubReq;
import com.sitech.cntt.vo.GetIaServCnttInfoQueryReq;
import com.sitech.cntt.vo.GetIaServCnttInfoQueryRsp;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

public interface IIaServCnttInfoQuery {
	public OutDTO<GetIaServCnttInfoQueryRsp>getCnttInfo(InDTO<PubReq<GetIaServCnttInfoQueryReq>>inDTO);
}
