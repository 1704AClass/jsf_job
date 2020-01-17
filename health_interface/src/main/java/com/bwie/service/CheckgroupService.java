package com.bwie.service;

import java.util.List;

import com.bwie.entity.PageResult;
import com.bwie.pojo.TCheckgroup;

public interface CheckgroupService {

	Object findAll();

	void add(TCheckgroup checkgroup, Integer[] checkitemIds);

	PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

	TCheckgroup findById(Integer id);

	List<Integer> findCheckItemIdsByCheckGroup(Integer id);

	void edit(TCheckgroup checkgroup, Integer[] checkitemIds);

}
