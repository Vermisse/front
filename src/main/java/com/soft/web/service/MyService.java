package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.model.InsertModel;
import com.soft.web.dao.my.MyMapper;

/**
 * 私人订制服务类
 * @author wang
 *
 */
@Service
public class MyService {
	
	@Autowired
	private MyMapper mapper;
	
	/**
	 * 添加私人订制订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  私人订制人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addMy(InsertModel insertModel) {
		return mapper.addMy(insertModel);
	}
	
	/**
	 * 根据状态查询私人订制订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryMyList(String id) {
		return mapper.queryMyList(id);
	}
	
}