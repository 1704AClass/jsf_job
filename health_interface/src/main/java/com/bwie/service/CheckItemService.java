package com.bwie.service;

import java.util.List;

import com.bwie.entity.PageResult;
import com.bwie.pojo.TCheckitem;

public interface CheckItemService {

	List<TCheckitem> checkItemList();

	PageResult findPage(Integer currentPage, Integer pageSize, String queryString);

	void add(TCheckitem checkitem);

	void delete(Integer id);

	void edit(TCheckitem checkitem);

	TCheckitem findById(Integer id);

}
