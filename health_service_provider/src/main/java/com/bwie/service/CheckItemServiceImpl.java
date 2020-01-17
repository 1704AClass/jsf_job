package com.bwie.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.bwie.entity.PageResult;
import com.bwie.mapper.TCheckgroupMapper;
import com.bwie.mapper.TCheckitemMapper;
import com.bwie.pojo.TCheckitem;
import com.bwie.service.CheckItemService;
@Service
public class CheckItemServiceImpl implements CheckItemService {

	@Autowired
	TCheckitemMapper checkitemMapper;
	@Autowired
	TCheckgroupMapper checkgroupMapper;
	@Override
	public List<TCheckitem> checkItemList() {
		// TODO Auto-generated method stub
		
		return checkitemMapper.selectByExample(null);
	}
	@Override
	public PageResult findPage(Integer currentPage, Integer pageSize, String queryString) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		Page<TCheckitem> page = checkitemMapper.selectByExample(queryString);
		return new PageResult(page.getTotal(),page.getResult());
	}
	@Override
	public void add(TCheckitem checkitem) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void edit(TCheckitem checkitem) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public TCheckitem findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
