package com.bwie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.bwie.pojo.CheckGroup;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.entity.PageResult;
import com.health.mapper.TCheckgroupMapper;
import com.health.mapper.TCheckitemMapper;
import com.health.pojo.TCheckgroup;
import com.health.pojo.TCheckgroupExample;
import com.health.pojo.TCheckgroupExample.Criteria;
import com.health.pojo.TCheckitem;
import com.health.service.CheckgroupService;
@Service
public class CheckgroupServiceImpl implements CheckgroupService {

	@Resource
	TCheckgroupMapper checkgroupMapper;
	@Resource
	TCheckitemMapper checkitemMapper;
	
	@Override
	public void add(TCheckgroup checkgroup, Integer[] checkitemIds) {
		// TODO Auto-generated method stub
		checkgroupMapper.insert(checkgroup);
		
	}
	//检查组和检查项的关联关系
	public void setCheckGroupAndCheckItem(Integer checkGroupId,Integer[] checkitemIds){
		if(checkitemIds !=null && checkitemIds.length>0){
			for (Integer checkitemId : checkitemIds) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("checkgroup_id", checkGroupId);
				map.put("checkitem_id", checkitemId);
				checkgroupMapper.setCheckGroupAndCheckItem(map);
			}
		}
	}
	@Override
	public PageResult pageQuery(Integer currentPage, Integer pageSize,
			String queryString) {
		// TODO Auto-generated method stub
		TCheckgroupExample example = new TCheckgroupExample();
		Criteria criteria = example.createCriteria();
		if(queryString!=null && !"".equals(queryString)){
			criteria.andHelpcodeLike("%"+queryString+"%");
		}
		PageHelper.startPage(currentPage, pageSize);
		PageInfo<TCheckgroup> info = new PageInfo<TCheckgroup>(checkgroupMapper.selectByExample(example));
		return new PageResult(info.getTotal(), info.getList());
	}
	//通过id回显
	@Override
	public TCheckgroup findById(Integer id) {
		// TODO Auto-generated method stub
		return checkgroupMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Integer> findCheckItemIdsByCheckGroup(Integer id) {
		// TODO Auto-generated method stub
		return checkgroupMapper.findCheckItemIdsByCheckGroup(id);
	}
	@Override
	public void edit(TCheckgroup checkgroup, Integer[] checkitemIds) {
		//根据检查组id删除中间表数据（清除关联数据）
		checkgroupMapper.deleteAssociation(checkgroup.getId());
		//网中间表里面插入数据
		setCheckGroupAndCheckItem(checkgroup.getId(),checkitemIds);
		//更新检查组基本信息
		checkgroupMapper.updateByPrimaryKey(checkgroup);
	}
	@Override
	public List<TCheckitem> findAll() {
		// TODO Auto-generated method stub
		return checkitemMapper.selectByExample(null);
	}
	@Override
	public void add(CheckGroup checkgroup, Integer[] checkitemIds) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public com.bwie.entity.PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CheckGroup findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void edit(CheckGroup checkgroup, Integer[] checkitemIds) {
		// TODO Auto-generated method stub
		
	}
	
}
