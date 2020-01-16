package com.bwie.service;

import java.util.List;

import com.bwie.entity.PageResult;
import com.bwie.pojo.CheckItem;

public interface CheckItemService {

	List<CheckItem> checkItemList();

	PageResult findPage(Integer currentPage, Integer pageSize, String queryString);

	void add(CheckItem checkitem);

	void delete(Integer id);

	void edit(CheckItem checkitem);

	CheckItem findById(Integer id);

}
