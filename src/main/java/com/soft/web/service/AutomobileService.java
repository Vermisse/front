package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.model.InsertModel;
import com.soft.web.dao.automobile.AutomobileMapper;

/**
 * 直通車服务类
 * @author wang
 *
 */
@Service
public class AutomobileService {
	
	@Autowired
	private AutomobileMapper mapper;
	
	/**
	 * 添加直通車订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  直通車人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addAutomobile(InsertModel insertModel) {
		return mapper.addAutomobile(insertModel);
	}
	
	/**
	 * 添加直通車订单详情
	 * @param id
	 * @param checkName
	 * @param cardId
	 * @param checkTel
	 * @param createTime
	 * @param updateTime
	 * @return
	 */
	public int addAutomobileDetail(int id, String checkName, String cardId, String createTime,
			String updateTime) {
		return mapper.addAutomobileDetail(id, checkName, cardId, createTime, updateTime);
	}

	/**
	 * 根据状态查询直通车票订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryAutomobileList(String id) {
		return mapper.queryAutomobileList(id);
	}
}