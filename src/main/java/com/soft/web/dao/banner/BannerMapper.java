package com.soft.web.dao.banner;

import java.util.*;

import org.apache.ibatis.annotations.*;

public interface BannerMapper {

	List<Map<String, Object>> queryBanner();
}