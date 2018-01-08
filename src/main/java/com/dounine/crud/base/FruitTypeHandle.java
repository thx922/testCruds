package com.dounine.crud.base;

import java.sql.CallableStatement;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
import org.apache.ibatis.type.BaseTypeHandler;  
import org.apache.ibatis.type.JdbcType;

import com.dounine.crud.enums.FruitType;  

public class FruitTypeHandle  extends BaseTypeHandler<FruitType>{

	    private Class<FruitType> type;  
	  
	    private  FruitType[] enums;  
	      
	    /** 
	     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现 
	     * @param type 配置文件中设置的转换类 
	     */  
	    public FruitTypeHandle(Class<FruitType> type) {  
	        if (type == null)  
	            throw new IllegalArgumentException("Type argument cannot be null");  
	        this.type = type;  
	        this.enums = type.getEnumConstants();  
	        if (this.enums == null)  
	            throw new IllegalArgumentException(type.getSimpleName()  
	                    + " does not represent an enum type.");  
	    }  
	  
	   
	    @Override  
	    public FruitType getNullableResult(ResultSet rs, String columnName) throws SQLException {  
	        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型  
	        String i = rs.getString(columnName);  
	        if (rs.wasNull()) {  
	            return null;  
	        } else {  
	            // 根据数据库中的value值，定位PersonType子类  
	            return FruitType.getEnum(Integer.parseInt(i));
	        }  
	    } 
	  

		/*@Override
		public FruitType getNullableResult(ResultSet arg0, String arg1) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}*/  
	    @Override  
	    public FruitType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {  
	        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型  
	    	 int i = rs.getInt(columnIndex);  
	        if (rs.wasNull()) {  
	            return null;  
	        } else {  
	             // 根据数据库中的value值，定位PersonType子类  
	            return FruitType.getEnum(i);  
	        }  
	    }  
	  
	    @Override  
	    public FruitType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {  
	         // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型  
	     int i = cs.getInt(columnIndex);  
	       if (cs.wasNull()) {  
	           return null;  
	       } else {  
	         // 根据数据库中的value值，定位PersonType子类  
	           return FruitType.getEnum(i);  
	       }  
	    }  
	  
	    @Override  
	    public void setNonNullParameter(PreparedStatement ps, int i, FruitType parameter, JdbcType jdbcType)  
	            throws SQLException {  
	        // baseTypeHandler已经帮我们做了parameter的null判断  
	        ps.setInt(i, parameter.getCode());  
	  
	    }

	      
	  
	
}
