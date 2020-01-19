package com.bwie.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.bwie.entity.PageResult;
import com.bwie.mapper.TCheckgroupMapper;
import com.bwie.mapper.TCheckitemMapper;
import com.bwie.pojo.TCheckitem;
import com.bwie.pojo.TCheckitemExample;
import com.bwie.pojo.TCheckitemExample.Criteria;
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
		
		return checkitemMapper.findByList();
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

	@Override
	public PageResult findPage(Integer currentPage, Integer pageSize, String queryString) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageSize);
		Page<TCheckitem> page = checkitemMapper.selectByExample(queryString);
		return new PageResult(page.getTotal(), page.getResult());
	}
	/*@Override
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
	}*/
	
}