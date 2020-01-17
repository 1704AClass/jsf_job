package com.bwie.mapper;

import com.bwie.pojo.TCheckitem;
import com.bwie.pojo.TCheckitemExample;
import com.github.pagehelper.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TCheckitemMapper {
    int countByExample(TCheckitemExample example);

    int deleteByExample(TCheckitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCheckitem record);

    int insertSelective(TCheckitem record);

    Page<TCheckitem> selectByExample(String queryString);

    TCheckitem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCheckitem record, @Param("example") TCheckitemExample example);

    int updateByExample(@Param("record") TCheckitem record, @Param("example") TCheckitemExample example);

    int updateByPrimaryKeySelective(TCheckitem record);

    int updateByPrimaryKey(TCheckitem record);

    @Select(value="select count(*) from t_checkgroup_checkitem where checkitem_id = #{checkitem_id}")
	long findCountByCheckItemId(Integer id);

}