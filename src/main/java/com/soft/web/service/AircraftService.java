package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.model.InsertModel;
import com.soft.web.dao.aircraft.AircraftMapper;

/**
 * 飞机票服务类
 * @author wang
 *
 */
@Service
public class AircraftService {
	
	@Autowired
	private AircraftMapper mapper;
	
	/**
	 * 添加飞机票订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  飞机票人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addAircraft(InsertModel insertModel) {
		return mapper.addAircraft(insertModel);
	}
	
	/**
	 * 添加飞机票订单详情
	 * @param id
	 * @param checkName
	 * @param cardId
	 * @param checkTel
	 * @param createTime
	 * @param updateTime
	 * @return
	 */
	public int addAircraftDetail(int id, String checkName, String cardId, String createTime,
			String updateTime) {
		return mapper.addAircraftDetail(id, checkName, cardId, createTime, updateTime);
	}
	
	/**
	 * 根据状态查询飞机票订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryAircraftList(String id) {
		return mapper.queryAircraftList(id);
	}
}