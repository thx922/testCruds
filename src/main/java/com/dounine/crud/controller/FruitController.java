package com.dounine.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.dounine.crud.base.ActResult;
import com.dounine.crud.base.Result;
import com.dounine.crud.dao.IFruitDAO;
import com.dounine.crud.entity.Fruit;
import com.dounine.crud.entity.Fruit2;
import com.dounine.crud.enums.FruitType;
import com.dounine.crud.service.FruitService;

//@CrossOrigin(origins = "http://localhost:63342", maxAge = 3600)
@Controller
@RequestMapping("/fruit")
//@RestController
public class FruitController {

	@Autowired
	private FruitService fruitService;

	/**
	 * 查询水果
	 * @param request
	 * @param name 水果名
	 * @return Result 
	 * @author tanghaixiang
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/name")
	@ResponseBody
	public Result findByName(HttpServletRequest request, String name) {
		
			List<Fruit> fruit = fruitService.getFruitByName(name);
			System.out.println(JSON.toJSONString(fruit));
//			model.addAttribute("actResult", fruit);
			// return "fruit";// new ActResult(fruit, "", 0);
			System.out.println( JSON.toJSONString(ActResult.initialize(fruit)));
			return ActResult.initialize(fruit);
//			return fruit;// new ActResult(fruit, "", 0);
			// entity转VO还没做
		
	}

	/**
	 * 添加水果功能
	 * @param request
	 * @param pyfabzkz 水果数据
	 * @return String 
	 * @author tanghaixiang
	 */
	@RequestMapping(method = RequestMethod.POST )
	@ResponseBody
	public String addOne(@RequestBody Fruit2 pyfabzkz, HttpServletRequest request,HttpServletResponse response ) {
		System.out.println( "s");
		
		String name = pyfabzkz.getName();
		Double price = Double.parseDouble(pyfabzkz.getPrice());
		String fruitType = pyfabzkz.getFruitType();
		Fruit fruit = new Fruit();
		fruit.setName(name);
		fruit.setPrice(price);
		switch (fruitType) {
		case "APPLES":
			fruit.setFruitType(FruitType.APPLES);
			break;
		case "ORANGE":
			fruit.setFruitType(FruitType.ORANGE);
			break;
		case "PEACH":
			fruit.setFruitType(FruitType.PEACH);
			break;
		}

		int result = fruitService.add(fruit);
		return null;
		// return "list";//new ActResult(null, "添加成功", 0);
	}
	

	/**
	 * 删除水果数组
	 * @param pyfabzkz 水果id数组
	 * @param request
	 * @return String
	 * @author tanghaixiang
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{pyfabzkz}")
	@ResponseBody
	public String deleteByIds(@PathVariable String[] pyfabzkz, HttpServletRequest request) {
		String[] id = pyfabzkz;
		Boolean result = fruitService.removeByIds(id);

		return "sucess";// new ActResult(null, "删除成功", 0);
	}

	/**
	 * 更新单个水果
	 * @param pyfabzkz
	 * @param request
	 * @return String
	 * @author tanghaixiang
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/updateOneFruit")
	@ResponseBody
	public String updateInfo( @RequestBody Fruit2 pyfabzkz ,HttpServletRequest request) {
		String id =pyfabzkz.getId();
		String name = pyfabzkz.getName();
		Double price = Double.parseDouble(pyfabzkz.getPrice());
		String fruitType =pyfabzkz.getFruitType();
		Fruit fruit1 = fruitService.getFruitById( id );
		fruit1.setName(name);
		fruit1.setPrice(price);
		switch (fruitType) {
		case "APPLES":
			fruit1.setFruitType(FruitType.APPLES);
			break;
		case "ORANGE":
			fruit1.setFruitType(FruitType.ORANGE);
			break;
		case "PEACH":
			fruit1.setFruitType(FruitType.PEACH);
			break;
		}
		Boolean result = fruitService.update(fruit1);
		return "list";// new ActResult(null, "编辑成功", 0);
	}
	
	/**
	 * 批量更新水果
	 * @param pyfabzkz 水果数组
	 * @param request
	 * @return String
	 * @author tanghaixiang
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/batchUpdatFruit")
	@ResponseBody
	public String batchUpdatFruit( @RequestBody List<Fruit2> pyfabzkz, HttpServletRequest request) {
		List<Fruit> list = new ArrayList<>();
		for(Fruit2 f: pyfabzkz ){
			String id =f.getId();
			String name = f.getName();
			Double price = Double.parseDouble(f.getPrice());
			String fruitType = f.getFruitType();
			Fruit fruit1 = new Fruit();;
			fruit1.setName(name);
			fruit1.setPrice(price);
			switch (fruitType) {
			case "APPLES":
				fruit1.setFruitType(FruitType.APPLES);
				break;
			case "ORANGE":
				fruit1.setFruitType(FruitType.ORANGE);
				break;
			case "PEACH":
				fruit1.setFruitType(FruitType.PEACH);
				break;
			}
			list.add(fruit1);
		}

		Boolean result = fruitService.updateBatch(list);
		return "success";// new ActResult(null, "编辑成功", 0);
	}
	
}
