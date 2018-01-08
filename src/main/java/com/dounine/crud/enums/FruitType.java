package com.dounine.crud.enums;

import java.util.HashMap;
import java.util.Map;

public enum FruitType {
	
	/**
	 * 苹果类
	 */
	APPLES(0),
	/**
	 * 橙子类
	 */
	ORANGE(1),
	/**
	 * 桃子类
	 */
	PEACH(2);
	
	private int code;
	
	 static Map<Integer,FruitType> enumMap=new HashMap<Integer, FruitType>();  
	    static{  
	        for(FruitType type:FruitType.values()){  
	            enumMap.put(type.getCode(), type);  
	        }  
	    } 
	    
	public int getCode( ){
		return code;
	}
	
	public void setCode( int code ){
		this.code = code;
	}
	
	private FruitType(int code) {
		this.code=code;
	}

	public static FruitType getEnum(int code ){
		return enumMap.get(code);
	}
	
}
