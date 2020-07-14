package com.sitech.cntt.inter;

import com.sitech.cntt.common.PubReq;
import com.sitech.cntt.vo.GetIaServconfigDictByRedisRsp;
import com.sitech.cntt.vo.SelectIaServconfigDictByAppCodeReq;
import com.sitech.cntt.vo.SelectIaServconfigDictByAppCodeRsp;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

public interface IIaServconfigDictQuery {
	/**
     * @author: wujc
     * @date: 2020/6/22
     * @Description: 根据应用编码查询服务配置列表
     */
    public OutDTO<SelectIaServconfigDictByAppCodeRsp> selectIaServconfigDictByAppCode(InDTO<PubReq<SelectIaServconfigDictByAppCodeReq>> inDTO) throws Exception;
    
    /**
     * @author: wujc
     * @date: 2020/6/29
     * @Description: 从redis获取服务配置列表
     */
    public OutDTO<GetIaServconfigDictByRedisRsp> getIaServconfigDictByRedis();
}
