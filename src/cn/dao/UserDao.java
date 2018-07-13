package cn.dao;

import cn.bean.User;

public interface UserDao
{
	public User login(String name_or_phone,String password);

	public boolean doUser(User user);
	
	public boolean checkUsername(String name);
	
	public boolean checkPhone(String phone);
	
	//ͨ��idչʾ������Ϣ
	public User showUserById(int id);

	
	public boolean update(User user);

}
