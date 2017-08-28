package com.soft.web.dao.hotel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.soft.web.dao.model.InsertModel;

/**
 * 酒店dao
 * 
 * @author wang
 *
 */
public interface HotelMapper {


	// 添加酒店订单
	int addHotel(InsertModel insertModel);

	// 添加酒店订单详情
	int addHotelDetail(@Param("o_id") int id, @Param("checkName") String checkName,
			@Param("cardId") String cardId,@Param("type") String type,
			@Param("createTime") String createTime,
			@Param("updateTime") String updateTime);
	
	// 根据用戶ID查询直通车订单详情列表
	List<Map> queryHotelList(@Param("u_id") String id);

}