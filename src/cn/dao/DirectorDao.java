package cn.dao;

import cn.bean.Director;

public interface DirectorDao {
	//ͨ��Director��ȡid
	int getIdByDirector(String director);
	
	//ͨ��id��ȡDirector
	String getDirectorById(int id);

	//ͨ��id��ȡDirector��
	Director findDirectorById(int id);
}
