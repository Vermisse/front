package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.hotel.HotelMapper;
import com.soft.web.dao.model.InsertModel;

/**
 * 酒店服务类
 * @author wang
 *
 */
@Service
public class HotelService {
	
	@Autowired
	private HotelMapper mapper;
	
	/**
	 * 添加酒店订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  入住人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addHotel(InsertModel insertModel) {
		return mapper.addHotel(insertModel);
	}
	
	/**
	 * 添加酒店订单详情
	 * @param id
	 * @param checkName
	 * @param cardId
	 * @param checkTel
	 * @param createTime
	 * @param updateTime
	 * @return
	 */
	public int addHotelDetail(int id, String checkName, String cardId, String type, String createTime,
			String updateTime) {
		return mapper.addHotelDetail(id, checkName, cardId, type, createTime, updateTime);
	}

	/**
	 * 根据状态查询酒店订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryHotelLists(String id) {
		return mapper.queryHotelLists(id);
	}
}