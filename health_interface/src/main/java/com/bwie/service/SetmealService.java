package com.bwie.service;

import com.bwie.entity.PageResult;
import com.bwie.pojo.TSetmeal;

public interface SetmealService {

	PageResult findPage(Integer currentPage, Integer pageSize, String queryString);

	void add(TSetmeal setmeal, Integer[] checkgroupIds);

}
