package cn.dao;

import cn.bean.Director;

public interface DirectorDao {
	//通过Director获取id
	int getIdByDirector(String director);
	
	//通过id获取Director
	String getDirectorById(int id);

	//通过id获取Director类
	Director findDirectorById(int id);
}
