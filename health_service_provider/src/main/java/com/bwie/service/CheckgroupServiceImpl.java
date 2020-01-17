package com.bwie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.bwie.entity.PageResult;
import com.bwie.mapper.TCheckgroupMapper;
import com.bwie.mapper.TCheckitemMapper;
import com.bwie.pojo.TCheckgroup;
import com.bwie.pojo.TCheckgroupExample;
import com.bwie.pojo.TCheckgroupExample.Criteria;
import com.bwie.pojo.TCheckitem;
import com.bwie.service.CheckgroupService;
@Service
public class CheckgroupServiceImpl implements CheckgroupService {

	@Resource
	TCheckgroupMapper checkgroupMapper;
	@Resource
	TCheckitemMapper checkitemMapper;
	@Override
	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void add(TCheckgroup checkgroup, Integer[] checkitemIds) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TCheckgroup findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Integer> findCheckItemIdsByCheckGroup(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void edit(TCheckgroup checkgroup, Integer[] checkitemIds) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
