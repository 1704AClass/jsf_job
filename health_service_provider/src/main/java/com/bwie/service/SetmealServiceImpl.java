package com.bwie.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.bwie.entity.PageResult;
import com.bwie.mapper.TSetmealMapper;
import com.bwie.pojo.TCheckgroup;
import com.bwie.pojo.TCheckgroupExample;
import com.bwie.pojo.TSetmeal;
import com.bwie.pojo.TSetmealExample;
import com.bwie.pojo.TSetmealExample.Criteria;
import com.bwie.pojo.TMemberExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SetmealServiceImpl implements SetmealService{

	@Autowired
	private TSetmealMapper mapper;
	@Override
	public PageResult findPage(Integer currentPage, Integer pageSize, String queryString) {
		TSetmealExample example = new TSetmealExample();
		Criteria criteria = example.createCriteria();
		if(queryString!=null && !"".equals(queryString)){
			criteria.andHelpcodeLike("%"+queryString+"%");
		}
		PageHelper.startPage(currentPage, pageSize);
		PageInfo<TSetmeal> info = new PageInfo<TSetmeal>(mapper.selectByExample(example));
		return new PageResult(info.getTotal(), info.getList());
	}

	@Override
	public void add(TSetmeal setmeal, Integer[] checkgroupIds) {
		// TODO Auto-generated method stub
		
	}

}
