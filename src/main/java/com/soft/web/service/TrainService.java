package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.model.InsertModel;
import com.soft.web.dao.train.TrainMapper;

/**
 * 火車票服务类
 * @author wang
 *
 */
@Service
public class TrainService {
	
	@Autowired
	private TrainMapper mapper;
	
	/**
	 * 添加火車票订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  火車票人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addTrain(InsertModel insertModel) {
		return mapper.addTrain(insertModel);
	}
	
	/**
	 * 添加火車票订单详情
	 * @param id
	 * @param checkName
	 * @param cardId
	 * @param checkTel
	 * @param createTime
	 * @param updateTime
	 * @return
	 */
	public int addTrainDetail(int id, String checkName, String cardId, String createTime,
			String updateTime) {
		return mapper.addTrainDetail(id, checkName, cardId, createTime, updateTime);
	}
	
	/**
	 * 根据状态查询火车票订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryTrainList(String id) {
		return mapper.queryTrainList(id);
	}
}