package cn.dao;

import java.util.List;

import cn.bean.Type;

public interface TypeDao {
	//通过查找id获取它的类型名
	String getNameById(int id);

	//通过查找名字来获取他的id
	int getIdByName(String name);
	
	List<Type> getAllType();

}
