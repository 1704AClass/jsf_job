package com.bwie.service;

import java.util.List;

import com.bwie.entity.PageResult;
import com.bwie.pojo.CheckGroup;

public interface CheckgroupService {

	Object findAll();

	void add(CheckGroup checkgroup, Integer[] checkitemIds);

	PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

	CheckGroup findById(Integer id);

	List<Integer> findCheckItemIdsByCheckGroup(Integer id);

	void edit(CheckGroup checkgroup, Integer[] checkitemIds);

}
