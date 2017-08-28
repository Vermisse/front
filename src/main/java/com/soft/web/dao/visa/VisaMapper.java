package com.soft.web.dao.visa;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.soft.web.dao.model.InsertModel;

/**
 * 签证dao
 * 
 * @author wang
 *
 */
public interface VisaMapper {

	// 添加签证订单
	int addVisa(InsertModel insertModel);

	// 添加签证订单详情
	int addVisaDetail(@Param("v_id") int id, @Param("checkName") String checkName, @Param("cardId") String cardId,
			@Param("createTime") String createTime,
			@Param("updateTime") String updateTime);
	
	// 根据状态查询签证订单列表
	List<Map> queryVisaList(@Param("u_id") String id);

}