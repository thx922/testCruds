package com.dounine.crud.fruit.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.dounine.crud.dao.IFruitDAO;
import com.dounine.crud.entity.Fruit;
import com.dounine.crud.enums.FruitType;
//import org.springframework.boot.test.SpringApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
//@SpringApplicationConfiguration(classes = SpringBootSampleApplication.class)
@WebAppConfiguration
@Configuration
public class TestFruit {
	private static Logger logger = Logger.getLogger(TestFruit.class);

	@Autowired
	private IFruitDAO fruitService = null;
	@Test
	public void testFind() {
		List<Fruit> fruits = fruitService.selectByName("x");
		
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info(JSON.toJSONString(fruits));
	}
	
	@Test
	public void testAdd() {
		Fruit fruit = new Fruit();
		fruit.setName("水蜜桃");
		fruit.setPrice(10.5);
		fruit.setFruitType(FruitType.PEACH);
		int result = fruitService.insert(fruit);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info(JSON.toJSONString(fruit));
		logger.info(result);
	}
	

	@Test
	public void testUpdate() {
		Fruit fruit = fruitService.selectById( "1514977051441" );
		fruit.setName("a");
		fruit.setPrice(11.5);
		fruit.setFruitType(FruitType.PEACH);
		Boolean result = fruitService.updateById(fruit);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info(JSON.toJSONString(fruit));
		logger.info(result);
	}
	

	@Test
	public void testDelete() {
//		Fruit fruit = fruitService.getFruitById( "1514977051441" );
//		int result = fruitService.removeByName(fruit.getName());
		 Boolean result = fruitService.deleteById("234");
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
//		logger.info(JSON.toJSONString(fruit));
		logger.info(result);
	}
}
