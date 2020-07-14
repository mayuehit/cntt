package com.sitech.cntt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sitech.cntt.common.PubReq;
import com.sitech.cntt.inter.IIaServCnttInfoQuery;
import com.sitech.cntt.metadata.domain.ConRel;
import com.sitech.cntt.vo.GetIaServCnttInfoQueryReq;
import com.sitech.cntt.vo.GetIaServCnttInfoQueryRsp;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.wrapper.support.OutDTOBuild;

@Service("IaServCnttInfoQueryServiceSvc")
@RequestMapping("/servCntt")
public class IaServCnttInfoQuery implements IIaServCnttInfoQuery{
	
	@PostMapping("/getCnttInfo")
	public OutDTO<GetIaServCnttInfoQueryRsp> getCnttInfo(@RequestBody InDTO<PubReq<GetIaServCnttInfoQueryReq>>inDTO){
		GetIaServCnttInfoQueryReq req=Optional.ofNullable(inDTO)
				.flatMap(mapper -> Optional.ofNullable(mapper.getBody()))
				.flatMap(mapper -> Optional.ofNullable(mapper.getBusiInfo()))
				.orElse(null);
				GetIaServCnttInfoQueryRsp rsp = new GetIaServCnttInfoQueryRsp();
				
	/*	
	 * 用原生ES进行查询 查询条件为号码+日期date
	 * RangeQueryBuilder rangeQueryBuilder;
	 * if(req.getQryType()==0){
	 * 		rangeQueryBuilder = QueryBuilders.boolQuery()
			.must(QueryBuilders.matchQuery(req.getPhoneNo())
			.must(QueryBuilders.rangeQuery("OP_TIME").gte(req.getStartTime).lte(req.getEndTime));
	 * }
	 * else if(req.getQryType()==1){
	 * 		rangeQueryBuilder = QueryBuilders.boolQuery()
			.must(QueryBuilders.matchQuery(req.getLoginNo())
			.must(QueryBuilders.rangeQuery("OP_TIME").gte(req.getStartTime).lte(req.getEndTime));
	 * }
		SearchResponse response = client.prepareSearch("blog").setTypes("article").setQuery(rangeQueryBuilder).get();
		SearchHits hits=response.getHits();
		Iterator<SearchHit>iterator=hits.iterator();
		List<ConRel>conRelList = new ArrayList<>();
		while(iterator.hasNext()) {
			SearchHit next=iterator.next();
			ConRel conRel = new ConRel();
			conRel.setOpcode((Integer)next.getSource().get(OP_CODE));
			conRel.setOpName((String)next.getSource().get(OP_NAME));
			conRel.setOpTime((Date)next.getSource().get(OP_TIME));
			conRel.setIdNo((String)next.getSource().get(ID_NO));
			conRel.setLoginAccept((String)next.getSource().get(LOGIN_ACCEPT));
			conRel.setPrice((Integer)next.getSource().get(PRICE));
			conRel.setAssureCustId((String)next.getSource().get(ASSURE_CUST_ID));
			conRel.setOpNote((String)next.getSource().get(OP_NOTE));
			conRelList.add(conRel);
		}
		*/
				
				
				
		/*查询hbase 查询条件为号码+日期
		 * 
		 * List <Filter>filters = new ArrayList<Filter>();
		String liezu;
		String str;
		if("0".equals(req.getQryType())) {
			liezu="PHONE_NO";
			str=req.getPhoneNo();
			
		}
		else if("1".equals(req.getQryType())) {
			liezu="LOGIN_NO";
			str=req.getLoginNo();
		}
		Filter filter0=new SingleColumnValueFilter(Bytes.toBytes("列族"),Bytes.toBytes(liezu),CompareOp.EQUAL,Bytes.toBytes(str));
		filters.add(filter0);
		Filter filter1=new SingleColumnValueFilter(Bytes.toBytes("列族"),Bytes.toBytes("OP_TIME"),CompareOp.GREATER_OR_EQUAL,Bytes.toBytes(req.getBeginTime()));
		filters.add(filter1);
		Filter filter2=new SingleColumnValueFilter(Bytes.toBytes("列族"),Bytes.toBytes("OP_TIME"),CompareOp.GREATER_OR_EQUAL,Bytes.toBytes(req.getEndTime()));
		filters.add(filter2);
		FilterList filterList1=new FilterList(filters);
		Scan scan = new Scan();
		scan.setFilter(filterList1);
		Table table = hbase.getConnection().getTable(TableName.valueOf(表名));
		ResultScanner rs = table.getScanner(scan);
		for(Result r:rs) {
			for(Cell cell:r.listCells()) {
				ConRel conRel = new ConRel();
				switch(Bytes.toString(cell.getQualifierArray(),cell.getQualifierOffset(),cell.getQualifierLength())) {
				case "OP_CODE":
					conRel.setOpCode(Bytes.toString(cell.getValueArray(),cell.getValueOffset(),cell.getValueLength()));
					break;
				case "OP_NAME":
					conRel.setOpName(Bytes.toString(cell.getValueArray(),cell.getValueOffset(),cell.getValueLength()));
					break;
				case "OP_TIME":
					conRel.setOpTime(Bytes.toString(cell.getValueArray(),cell.getValueOffset(),cell.getValueLength()));
					break;
				case "OP_NOTE":
					conRel.setOpNote(Bytes.toString(cell.getValueArray(),cell.getValueOffset(),cell.getValueLength()));
					break;
				case "OP_CODE":
					conRel.setOpCode(Bytes.toString(cell.getValueArray(),cell.getValueOffset(),cell.getValueLength()));
					break;
				case "OP_CODE":
					conRel.setOpCode(Bytes.toString(cell.getValueArray(),cell.getValueOffset(),cell.getValueLength()));
					break;
				}
				conRelList.add(conRel);
			}
		}
		*/
		ConRel conRel = new ConRel();
		conRel.setOpCode(1);
		conRel.setOpName("操作名");
		conRel.setOpTime(new Date(5555555));
		conRel.setIdNo("主产品实例ID");
		conRel.setLoginAccept("注册许可");
		conRel.setPrice(60);
		conRel.setLoginNo("工号");
		conRel.setAssureCustId("担保人客户标识");
		conRel.setPhoneNo("在客服中相当于受理号码");
		conRel.setBillId("票号 发票或者免填单号");
		conRel.setSubOrderId("子订单号");
		conRel.setTotalFee(60);
		conRel.setChnn("渠道名");
		conRel.setOpNote("操作日志");
		
		ConRel conRel2 = new ConRel();
		conRel2.setOpCode(1);
		conRel2.setOpName("操作名");
		conRel2.setOpTime(new Date(5555555));
		conRel2.setIdNo("主产品实例ID");
		conRel2.setLoginAccept("注册许可");
		conRel2.setPrice(60);
		conRel2.setLoginNo("工号");
		conRel2.setAssureCustId("担保人客户标识");
		conRel2.setPhoneNo("在客服中相当于受理号码");
		conRel2.setBillId("票号 发票或者免填单号");
		conRel2.setSubOrderId("子订单号");
		conRel2.setTotalFee(60);
		conRel2.setChnn("渠道名");
		conRel2.setOpNote("操作日志");
		rsp.setSize(2);
		List<ConRel>conRelList = new ArrayList<>();
		conRelList.add(conRel);
		conRelList.add(conRel2);
		rsp.setConRelList(conRelList);
		
		return OutDTOBuild.builder().returnCode("0").returnMsg("根据应用编码查询服务配置列表成功").build(rsp);
	}
}
