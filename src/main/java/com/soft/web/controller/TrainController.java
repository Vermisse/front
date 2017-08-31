package com.soft.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.util.CookieUtil;
import com.soft.util.DateUtil;
import com.soft.web.dao.model.InsertModel;
import com.soft.web.service.ConfigService;
import com.soft.web.service.IndexService;
import com.soft.web.service.TrainService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 火車票操作类
 * @author wang
 *
 */
@Controller
@RequestMapping("train")
public class TrainController {
	// 时间格式
	private final String format = "yyyy-MM-dd HH:mm:ss";
	
	@Autowired 
	private TrainService trainService;
	@Autowired 
	private IndexService indexService;
	@Autowired
	private ConfigService configService;
	
	@RequestMapping("addTrain")
	public String train(Model model) {
		model.addAttribute("config", configService.queryConfig());
		return "/train";
	}
		
	
	/**
	 * 添加火車票订单
	 * @param peopleNum 火車票人数
	 * @param address  火車票地点
	 * @param checkStartTiIme 火車票开始时间
	 * @param checkEndTime 火車票结束时间
	 */
	@RequestMapping("add")
	@ResponseBody
	public String addTrain(String userName, String userTel, String peopleNum, String address, 
			String startAddress, String endAddress, String date1, String date2, String jsonArray, HttpServletRequest request) {
		// 获取登陆者的用户名+手机号码
//		String userName = "";
//		String userTel = "";
		if(userName == null || "".equals(userName) || 
				userTel == null || "".equals(userTel)) {
			List<Map<String, Object>> list = indexService.queryUser(CookieUtil.getCookie(request));
			if(list.size() > 0) {
				userName = (String)list.get(0).get("real_name");
				userTel = (String)list.get(0).get("mobile");
			}
		}
		String createTime = DateUtil.getNow(format);
		String updateTime = DateUtil.getNow(format);
		InsertModel insertModel = new InsertModel();
//		{"jsonArray":JSON.stringify(jsonArray), "peopleNum":jsonArray.length, "userName":userName, 
//			"userTel":userTel, "startAddress":startAddress, "endAddress":endAddress, "date1":date1, "date2":date2};
		insertModel.setAddress(address);
		insertModel.setCreateTime(createTime);
		insertModel.setPeopleNum(peopleNum);
		insertModel.setUpdateTime(updateTime);
		insertModel.setUserName(userName);
		insertModel.setUserTel(userTel);
		
		insertModel.setStartAddress(startAddress);
		insertModel.setEndAddress(endAddress);
		insertModel.setDate1(date1);
		insertModel.setDate2(date2);
		trainService.addTrain(insertModel);
		int id = insertModel.getId();
		try {
			// 插入火車票详情
			JSONArray jsonArray2 = JSONArray.fromObject(jsonArray);
			for (int i = 0; i < jsonArray2.size(); i++) {
				JSONObject jsonObject = jsonArray2.getJSONObject(i);
				trainService.addTrainDetail(id, jsonObject.getString("checkName"), jsonObject.getString("cardId"), createTime, updateTime);
			}
		} catch (Exception e) {
			// TODO: error
			e.printStackTrace();
		}
		return "{\"id\":" + id + "}";
	}
	
	@RequestMapping("list")
	public String list(Model model, HttpServletRequest request) {
		String id = CookieUtil.getCookie(request);
		if("".equals(id)) {
			return "login";
		}
		List<Map> list = trainService.queryTrainList(id);
		model.addAttribute("list", list);
		model.addAttribute("config", configService.queryConfig());
		return "trainList";
	}
}