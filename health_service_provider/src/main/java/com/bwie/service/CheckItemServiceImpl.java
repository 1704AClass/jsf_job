package com.health.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.entity.PageResult;
import com.health.mapper.TCheckgroupMapper;
import com.health.mapper.TCheckitemMapper;
import com.health.pojo.TCheckgroupExample;
import com.health.pojo.TCheckitem;
import com.health.pojo.TCheckitemExample;
import com.health.pojo.TCheckitemExample.Criteria;
import com.health.service.CheckItemService;
@Service
public class CheckItemServiceImpl implements CheckItemService {

	@Resource
	TCheckitemMapper checkitemMapper;
	@Resource
	TCheckgroupMapper checkgroupMapper;

	@Override
	public List<TCheckitem> checkItemList() {
		// TODO Auto-generated method stub
		return checkitemMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int page, int size, String queryString) {
		// TODO Auto-generated method stub
		TCheckitemExample example = new TCheckitemExample();
		Criteria criteria = example.createCriteria();
		if(queryString!=null && !"".equals(queryString)){
			criteria.andNameLike("%"+queryString+"%");
		}
		PageHelper.startPage(page, size);
		PageInfo<TCheckitem> info = new PageInfo<TCheckitem>(checkitemMapper.selectByExample(example));
		return new PageResult(info.getTotal(), info.getList());
	}

	@Override
	public void add(TCheckitem checkitem) {
		// TODO Auto-generated method stub
		checkitemMapper.insert(checkitem);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		//查询当前检查是否和检查组关联
		//查询中间表   
		long count = checkitemMapper.findCountByCheckItemId(id);
		if(count>0){
			throw new RuntimeException("当前检查组被引用，不能删除");
		}
		checkitemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void edit(TCheckitem checkitem) {
		// TODO Auto-generated method stub
		checkitemMapper.updateByPrimaryKey(checkitem);
	}

	@Override
	public TCheckitem findById(Integer id) {
		// TODO Auto-generated method stub
		return checkitemMapper.selectByPrimaryKey(id);
	}
	
}
