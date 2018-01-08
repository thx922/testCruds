package com.dounine.crud.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dounine.crud.dao.IFruitDAO;
import com.dounine.crud.entity.Fruit;

@Service("fruitService")
public class FruitService  {

	// @Resource
	@Autowired
	private IFruitDAO fruitDAO;

	/**
	 * 查询水果
	 * @param name 水果名
	 * @return List<Fruit>
	 * @author tanghaixiang
	 * */
	public List<Fruit> getFruitByName(String name) {
		// TODO Auto-generated method stub
		return fruitDAO.selectByName(name);
	}
	
	/**
	 * 删除单个水果
	 * @param ids 水果编号数组
	 * @return Boolean
	 * @author tanghaixiang
	 * */
	public Boolean removeByIds(String[] ids) {
		// TODO Auto-generated method stub
		return fruitDAO.deleteByIds(ids);
	}

	/**
	 * 添加单个水果
	 * @param fruit 水果
	 * @return int
	 * @author tanghaixiang
	 * */
	public int add(Fruit fruit) {
		// TODO Auto-generated method stub
		Date date = new Date();

		fruit.setId(date.getTime() + "");
		return fruitDAO.insert(fruit);
	}
	/**
	 * 更新单个水果
	 * @param fruit 水果
	 * @return Boolean
	 * @author tanghaixiang
	 * */
	public Boolean update(Fruit fruit) {
		// TODO Auto-generated method stub
		return fruitDAO.updateById(fruit);
	}
	
	/**
	 * 批量更新水果
	 * @param list 水果數組
	 * @return Boolean
	 * @author tanghaixiang
	 * */
	public Boolean updateBatch(List<Fruit> fruits) {
		// TODO Auto-generated method stub
		return fruitDAO.updateBatch(fruits);
	}
	
	/**
	 * 查询水果
	 * @param id 水果编号
	 * @return Fruit 水果
	 * @author tanghaixiang
	 * */
	public Fruit getFruitById(String id) {
		// TODO Auto-generated method stub
		return fruitDAO.selectById(id);
	}
	/**
	 * 根据水果名删除水果
	 * @param name 水果名
	 * @return int
	 * @author tanghaixiang
	 * */
	public int removeByName(String name) {
		// TODO Auto-generated method stub
		return fruitDAO.deleteByName(name);
	}

	/**
	 * 删除单个水果
	 * @param id 水果编号
	 * @return Boolean 
	 * @author tanghaixiang
	 * */
	public Boolean removeById(String id) {
		// TODO Auto-generated method stub
		return fruitDAO.deleteById(id);
	}

}
