package com.soft.web.dao.my;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.soft.web.dao.model.InsertModel;

/**
 * 私人订制dao
 * 
 * @author wang
 *
 */
public interface MyMapper {

	// 添加私人订制
	int addMy(InsertModel insertModel);

	// 根据状态查询私人订制列表
	List<Map> queryMyList(@Param("u_id") String id);

}