package com.bwie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

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

	@Autowired
	TCheckgroupMapper checkgroupMapper;
	@Autowired
	TCheckitemMapper checkitemMapper;
	@Override
	public void add(TCheckgroup checkgroup, Integer[] checkitemIds) {
		// TODO Auto-generated method stub
		checkgroupMapper.insert(checkgroup);
		
	}
	/*//检查组和检查项的关联关系
	public void setCheckGroupAndCheckItem(Integer checkGroupId,Integer[] checkitemIds){
		if(checkitemIds !=null && checkitemIds.length>0){
			for (Integer checkitemId : checkitemIds) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("checkgroup_id", checkGroupId);
				map.put("checkitem_id", checkitemId);
				checkgroupMapper.setCheckGroupAndCheckItem(map);
			}
		}
	}*/
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
	/*@Override
	public List<Integer> findCheckItemIdsByCheckGroup(Integer id) {
		// TODO Auto-generated method stub
		return checkgroupMapper.findCheckItemIdsByCheckGroup(id);
	}*/
	//@Override
	/*public void edit(TCheckgroup checkgroup, Integer[] checkitemIds) {
		//根据检查组id删除中间表数据（清除关联数据）
		checkgroupMapper.deleteByPrimaryKey(checkgroup.getId());
		//网中间表里面插入数据
		setCheckGroupAndCheckItem(checkgroup.getId(),checkitemIds);
		//更新检查组基本信息
		checkgroupMapper.updateByPrimaryKey(checkgroup);
	}*/
	@Override
	public List<TCheckitem> findAll() {
		// TODO Auto-generated method stub
		return checkitemMapper.selectByExample(null);
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

