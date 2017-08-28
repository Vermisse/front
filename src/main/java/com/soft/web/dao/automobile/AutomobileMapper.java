package com.soft.web.dao.automobile;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.soft.web.dao.model.InsertModel;

/**
 * 直通車dao
 * 
 * @author wang
 *
 */
public interface AutomobileMapper {

	// 添加直通車订单
	int addAutomobile(InsertModel insertModel);

	// 添加直通車订单详情
	int addAutomobileDetail(@Param("t_id") int id, @Param("checkName") String checkName, @Param("cardId") String cardId,
			@Param("createTime") String createTime,
			@Param("updateTime") String updateTime);
	
	// 根据状态查询直通車订单列表
	List<Map> queryAutomobileList(@Param("u_id") String id);

}