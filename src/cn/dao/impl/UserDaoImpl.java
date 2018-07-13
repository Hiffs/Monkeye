package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.User;
import cn.dao.UserDao;
import cn.dbc.Base;

public class UserDaoImpl implements UserDao
{
	Base bs=new Base();
	@Override
	public User login(String name_or_phone, String password)
	{
		User user=new User();
		String sql="select * from user where (name=? or phone=?) and password=?";
		List<Object> list=new ArrayList<Object>();
		list.add(name_or_phone);
		list.add(name_or_phone);
		list.add(password);
		List<User> us=bs.getQuery(sql, list, User.class);
		if(us.size()>0)
		{
			user=us.get(0);
		}
		return user;
	}

	@Override
	public boolean doUser(User user)
	{
		boolean isFlag=false;
		String sql="insert into user(portrait_id,name,password,phone) values(1,?,?,?)";
		List<Object> list=new ArrayList<Object>();
		list.add(user.getName());
		list.add(user.getPassword());
		list.add(user.getPhone());
		boolean flag=bs.getUpdate(sql, list);
		if(flag)
		{
			isFlag=true;
		}
		return isFlag;
	}

	@Override
	public boolean checkUsername(String name)
	{
		boolean isFlag=false;
		String sql="select * from user where name=?";
		List<Object> list=new ArrayList<Object>();
		list.add(name);
		List<User> u=bs.getQuery(sql, list, User.class);
		if(u.size()>0)
		{
			isFlag=true;
		}
		return isFlag;
	}

	@Override
	public boolean checkPhone(String phone)
	{
		boolean isFlag=false;
		String sql="select * from user where phone=?";
		List<Object> list=new ArrayList<Object>();
		list.add(phone);
		List<User> u=bs.getQuery(sql, list, User.class);
		if(u.size()>0)
		{
			isFlag=true;
		}
		return isFlag;
	}


	@Override
	public User showUserById(int id) {
		String sql="select * from user where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<User> users=bs.getQuery(sql, list, User.class);
		return users.get(0);
	}


	@Override
	public boolean update(User user){
		boolean isFlag=false;
		String sql="update user set name=?,sex=?,birth=?,marriage=?,job=?,interests=?,introduce=? where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(user.getName());
		list.add(user.getSex());
		list.add(user.getBirth());
		list.add(user.getMarriage());
		list.add(user.getJob());
		list.add(user.getInterests());
		list.add(user.getIntroduce());
		list.add(user.getId());
		isFlag=bs.getUpdate(sql, list);
		return isFlag;
	}

}
