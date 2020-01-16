package com.bwie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bwie.entity.PageResult;
import com.bwie.entity.QueryPageBean;
import com.bwie.entity.Result;
import com.bwie.pojo.CheckItem;
import com.bwie.service.CheckItemService;


@RestController
@RequestMapping("/checkItem")
public class CheckItemController {

	@Reference
	CheckItemService checkItemService;
	
	@RequestMapping("/checkItemList")
	public List<CheckItem> checkItemList(){
		return checkItemService.checkItemList();
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
		PageResult pageResult = checkItemService.findPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize(), queryPageBean.getQueryString());
		return pageResult;
	}
	
	@RequestMapping("/add")
	public Result add(@RequestBody CheckItem checkitem){
		try {
			checkItemService.add(checkitem);
			return new Result(true, "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			return new Result(false, "");
		}
	}
	
	@RequestMapping("/delete")
	public Result delete(Integer id){
		try {
			checkItemService.delete(id);
			return new Result(true, "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			return new Result(false, "");
		}
	}
	
	@RequestMapping("/edit")
	public Result edit(@RequestBody CheckItem checkitem){
		try {
			checkItemService.edit(checkitem);
			return new Result(true, "编辑成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			return new Result(false, "编辑失败");
		}
	}
	
	@RequestMapping("/findById")
	public Result findById(Integer id){
		try {
			CheckItem checkitem = checkItemService.findById(id);
			return new Result(true, "成功", checkitem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			return new Result(false, "未获取到信息");
		}
	}
}
