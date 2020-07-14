package com.sitech.cntt.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author: wujc
 * @date: 2020/6/8
 * @Description: hbase工具类
 */
@Service
public class HBaseUtil {
	
	private static final Logger log = LogManager.getLogger(HBaseUtil.class);

	static Configuration conf =null;
    static{
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        System.setProperty("HADOOP_USER_NAME", resourceBundle.getString("hbase.name"));
        conf= HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", resourceBundle.getString("hbase.zookeeper.quorum"));
        conf.set("hbase.zookeeper.property.clientPort",resourceBundle.getString("hbase.zookeeper.property.clientPort"));
    }
    
    /**
     * @apiNote 创建表
     * @param tableName 表名
     * @param family 列族名数组
     */
    public void createTable(String tableName, String[] family) throws Exception {
    	HBaseAdmin admin=new HBaseAdmin(conf);
        HTableDescriptor hTableDescriptor =new HTableDescriptor(tableName);

        for(int i=0;i<family.length;i++){
        	log.info("列族"+(i+1)+"："+family[i]);
        	//添加列族
        	hTableDescriptor.addFamily(new HColumnDescriptor(family[i]));
        }
        if(admin.tableExists(tableName)){
        	log.info("表"+tableName+"已经存在");
        }else{
        	//创建表
            admin.createTable(hTableDescriptor);
            if (admin.tableExists(tableName)) {
            	log.info("表"+tableName+"创建成功");
			}else {
				log.info("表"+tableName+"创建失败");
			}
        }
    }
    
    /**
     * @apiNote 创建表
     * @param tableName 表名
     * @param hTableDescriptor
     */
    public void createTable(String tableName, HTableDescriptor hTableDescriptor) throws Exception {
        HBaseAdmin admin=new HBaseAdmin(conf);
        if(admin.tableExists(tableName)){
        	log.info("表"+tableName+"已经存在");
        }else{
        	//创建表
            admin.createTable(hTableDescriptor);
            if (admin.tableExists(tableName)) {
            	log.info("表"+tableName+"创建成功");
			}else {
				log.info("表"+tableName+"创建失败");
			}
        }
    }
    
    /**
     * @apiNote 查看表属性
     * @param tableName 表名
     * @return list 列族名集合
     */
    public List<String> descTable(String tableName) throws Exception {
        HBaseAdmin admin=new HBaseAdmin(conf);
        HTable hTable=new HTable(conf, tableName);
        HTableDescriptor hTableDescriptor =hTable.getTableDescriptor();
        HColumnDescriptor[] hColumnDescriptors = hTableDescriptor.getColumnFamilies();
        List<String> list = new ArrayList<String>();
        for(HColumnDescriptor t:hColumnDescriptors){
        	list.add(Bytes.toString(t.getName()));
        }
        return list;
    }
    
    /**
     * @apiNote 修改表的列族（全部替换）
     * @param tableName 表名
     * @param family 列族名数组
     */
    public void modifyTable(String tableName,String[] family) throws Exception {
        HBaseAdmin admin=new HBaseAdmin(conf);
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        for(int i=0;i<family.length;i++){
        	hTableDescriptor.addFamily(new HColumnDescriptor(family[i]));
        }
        admin.modifyTable(tableName, hTableDescriptor);
        log.info("表"+tableName+"修改成功");
    }
    
    /**
     * @apiNote 获取所有表名
     * @return String[] 表名数组
     */
    public String[] getAllTables() throws Exception {
        HBaseAdmin admin =new HBaseAdmin(conf);      
        String[] tableNames = admin.getTableNames();
        return tableNames;
    }
    
    /**
     * @apiNote 新增单条数据/更新单条数据
     * @param tableName 表名
     * @param rowKey 行键
     * @param familyName 列族
     * @param columnName 列限定符
     * @param value 值
     */
    public void putData(String tableName, String rowKey, String familyName, String columnName, String value)
            throws Exception {
    	log.info("表"+tableName+"，行键"+rowKey+"，列族"+familyName+"，列限定符"+columnName+"，值"+value);
        HTable htable=new HTable(conf, Bytes.toBytes(tableName));
        Put put=new Put(Bytes.toBytes(rowKey));
        put.add(Bytes.toBytes(familyName), Bytes.toBytes(columnName), Bytes.toBytes(value));
        htable.put(put);   
        log.info("新增数据成功");
    }
    
    /**
     * @apiNote 根据map新增数据
     * @param tableName 表名
     * @param rowKey 行键
     * @param family 列族
     * @param map key=列限定符，value=值
     */
    public void putRowByMap(String tableName, String rowKey, String family, Map<String, Object> map) throws Exception {
		HTable table = null;
		try {
			table = new HTable(conf, Bytes.toBytes(tableName));
			Put put = new Put(Bytes.toBytes(rowKey));
			for (Iterator localIterator = map.keySet().iterator(); localIterator.hasNext();) {
				String key = (String) localIterator.next();
				put.add(Bytes.toBytes(family), Bytes.toBytes(key),
						Bytes.toBytes(map.get(key).toString()));
			}
			table.put(put);
		} catch (Exception e) {
			e.printStackTrace();		
			table.close();
		} finally {
			table.close();
		}
    }
    
    /**
     * @apiNote 根据行键查询数据
     * @param tableName 表名
     * @param rowKey 行键
     * @return Result
     */
    public Result getResult(String tableName, String rowKey) throws Exception {
        Get get=new Get(Bytes.toBytes(rowKey));
        HTable htable=new HTable(conf, Bytes.toBytes(tableName));
        Result result=htable.get(get);
        return result;
    }
    
    /**
     * @apiNote 根据行键、列族、列限定符、版本查询数据
     * @param tableName 表名
     * @param rowKey 行键
     * @param familyName 列族
     * @param columnName 列限定符
     * @return Result
     */
    public Result getResult(String tableName, String rowKey, String familyName, String columnName) throws Exception {
        Get get=new Get(Bytes.toBytes(rowKey));
        HTable htable=new HTable(conf, Bytes.toBytes(tableName));
        get.addColumn(Bytes.toBytes(familyName),Bytes.toBytes(columnName));
        Result result=htable.get(get);
        return result;
    }
    
    /**
     * @apiNote 查询指定表所有数据
     * @param tableName 表名
     * @return ResultScanner
     */
    public ResultScanner getResultScann(String tableName) throws Exception {
     
        Scan scan=new Scan();
        ResultScanner rs =null;
        HTable htable=new HTable(conf, tableName);
        rs=htable.getScanner(scan);
        return rs;
    }
    
    /**
     * @apiNote 条件查询指定表所有数据
     * @param tableName 表名
     * @param scan 扫描
     * @return ResultScanner
     */
    public ResultScanner getResultScann(String tableName, Scan scan) throws Exception {
        ResultScanner rs =null;
        HTable htable=new HTable(conf, tableName);
        rs=htable.getScanner(scan);
        return rs;
    }
    
    /**
     * @apiNote 根据行键、列族、列限定符、版本查询数据
     * @param tableName 表名
     * @param rowKey 行键
     * @param familyName 列族
     * @param columnName 列限定符
     * @param versions 版本
     * @return Result
     */
    public Result getResultByVersion(String tableName, String rowKey, String familyName, String columnName, int versions) throws Exception {  
        HTable htable=new HTable(conf, tableName);
        Get get =new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
        get.setMaxVersions(versions);
        Result result=htable.get(get);
        return result;
    }
    
    /**
     * @apiNote 删除指定数据
     * @param tableName 表名
     * @param rowKey 行键
     * @param falilyName 列族
     * @param columnName 列限定符
     */
    public void deleteColumn(String tableName, String rowKey, String falilyName, String columnName) throws Exception {
        HTable htable=new HTable(conf, tableName);
        Delete de =new Delete(Bytes.toBytes(rowKey));
        de.deleteColumn(Bytes.toBytes(falilyName), Bytes.toBytes(columnName));
        htable.delete(de);
    }
    
    /**
     * @apiNote 删除指定行键数据
     * @param tableName
     * @param rowKey
     * @throws Exception
     */
    public void deleteColumn(String tableName, String rowKey) throws Exception {
        HTable htable=new HTable(conf, tableName);
        Delete de =new Delete(Bytes.toBytes(rowKey));
         htable.delete(de);       
    }
    
    /**
     * @apiNote 使指定表失效
     * @param tableName 表名
     */
    public void disableTable(String tableName) throws Exception {
        HBaseAdmin admin=new HBaseAdmin(conf);
        admin.disableTable(tableName);    
    }
 
    /**
     * @apiNote 删除指定表
     * @param tableName
     */
    public void dropTable(String tableName) throws Exception { 
        HBaseAdmin admin=new HBaseAdmin(conf);
        admin.disableTable(tableName);
        admin.deleteTable(tableName);        
    }
    
    /**
     * @apiNote 判断表是否存在
     * @param tableName 表名
     * @return boolean
     */
    public boolean tableExist(String tableName) throws Exception{
        HBaseAdmin hBaseAdmin = new HBaseAdmin(conf);
        boolean tableExists = hBaseAdmin.tableExists(tableName);
        hBaseAdmin.close();
        return tableExists;
    }
    
}
