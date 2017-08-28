package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.model.InsertModel;
import com.soft.web.dao.visa.VisaMapper;

/**
 * 签证服务类
 * @author wang
 *
 */
@Service
public class VisaService {
	
	@Autowired
	private VisaMapper mapper;
	
	/**
	 * 添加签证订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  签证人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addVisa(InsertModel insertModel) {
		return mapper.addVisa(insertModel);
	}
	
	/**
	 * 添加签证订单详情
	 * @param id
	 * @param checkName
	 * @param cardId
	 * @param checkTel
	 * @param createTime
	 * @param updateTime
	 * @return
	 */
	public int addVisaDetail(int id, String checkName, String cardId, String createTime,
			String updateTime) {
		return mapper.addVisaDetail(id, checkName, cardId, createTime, updateTime);
	}
	
	/**
	 * 根据状态查询签证订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryVisaList(String id) {
		return mapper.queryVisaList(id);
	}
}