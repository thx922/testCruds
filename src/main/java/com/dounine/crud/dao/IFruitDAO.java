package com.dounine.crud.dao;

import java.util.List;

import com.dounine.crud.entity.Fruit;

public interface IFruitDAO {

	/**
	 * 查询水果
	 * @return List<Fruit>
	 * @author tanghaixiang
	 * */
	List<Fruit> selectByName(String name);
	
	/**
	 * 删除单个水果
	 * @param id 水果编号
	 * @return Boolean
	 * @author tanghaixiang
	 * */
	Fruit selectById(String id);

	/**
	 * 根据水果名删除单个水果
	 * @param name 水果名
	 * @return int
	 * @author tanghaixiang
	 * */
	int deleteByName(String name);

	/**
	 * 删除单个水果
	 * @param id 水果编号
	 * @return Boolean
	 * @author tanghaixiang
	 * */
	Boolean deleteById(String id);
	/**
	 * 删除单个水果
	 * @param id 水果编号
	 * @return Boolean
	 * @author tanghaixiang
	 * */
	Boolean deleteByIds(String[] id);
	/**
	 * 添加单个水果
	 * @param fruit 水果
	 * @return int
	 * @author tanghaixiang
	 * */
	int insert(Fruit fruit);
	/**
	 * 跟新单个水果
	 * @param fruit 水果
	 * @return Boolean
	 * @author tanghaixiang
	 * */
	Boolean updateById(Fruit fruit);
	/**
	 * 批量跟新水果
	 * @param list 水果數組
	 * @return Boolean
	 * @author tanghaixiang
	 * */
	Boolean updateBatch(List<Fruit> list);

}
