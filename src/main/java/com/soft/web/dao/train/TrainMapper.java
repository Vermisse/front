package com.soft.web.dao.train;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.soft.web.dao.model.InsertModel;

/**
 * 火車票dao
 * 
 * @author wang
 *
 */
public interface TrainMapper {

	// 添加火車票订单
	int addTrain(InsertModel insertModel);

	// 添加火車票订单详情
	int addTrainDetail(@Param("t_id") int id, @Param("checkName") String checkName, @Param("cardId") String cardId,
			@Param("createTime") String createTime,
			@Param("updateTime") String updateTime);
	
	// 根据状态查询火車票订单列表
	List<Map> queryTrainList(@Param("u_id") String id);

}