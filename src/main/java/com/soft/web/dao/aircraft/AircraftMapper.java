package com.soft.web.dao.aircraft;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.soft.web.dao.model.InsertModel;

/**
 * 飞机票dao
 * 
 * @author wang
 *
 */
public interface AircraftMapper {

	// 添加飞机票订单
	int addAircraft(InsertModel insertModel);

	// 添加飞机票订单详情
	int addAircraftDetail(@Param("t_id") int id, @Param("checkName") String checkName, @Param("cardId") String cardId,
			@Param("createTime") String createTime,
			@Param("updateTime") String updateTime);
	
	// 根据状态查询飞机票订单列表
	List<Map> queryAircraftList(@Param("u_id") String id);

}