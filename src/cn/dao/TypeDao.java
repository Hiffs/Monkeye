package cn.dao;

import java.util.List;

import cn.bean.Type;

public interface TypeDao {
	//ͨ������id��ȡ����������
	String getNameById(int id);

	//ͨ��������������ȡ����id
	int getIdByName(String name);
	
	List<Type> getAllType();

}
