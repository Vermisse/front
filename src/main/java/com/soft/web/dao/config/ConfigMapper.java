package com.soft.web.dao.config;

import java.util.*;

import org.apache.ibatis.annotations.*;

public interface ConfigMapper {

	Map<String, Object> queryConfig();
}