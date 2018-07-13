package cn.demo;

import java.util.List;

import org.junit.Test;

import cn.bean.Film;
import cn.bean.User;
import cn.dao.FilmDao;
import cn.dao.UserDao;
import cn.dao.impl.FilmDaoImpl;
import cn.dao.impl.UserDaoImpl;

public class Fan_Demo
{
	UserDao ud=new UserDaoImpl();
	FilmDao fd=new FilmDaoImpl();
	//²âÊÔµÇÂ¼
	@Test
	public void test_login()
	{
		User user=ud.login("ffh","123456");
		System.out.println(user.getId());
	}
	@Test
	public void test()
	{
		User u=new User();
		u.setName("Jack");
		u.setPassword("654321");
		u.setPhone("13710648691");
		boolean flag=ud.doUser(u);
		System.out.println(flag);
	}
	@Test
	public void test01()
	{
		boolean flag=true;
		if(flag)
		{
			System.out.println("flag:"+flag);
		}
		else
		{
			System.out.println("!flag:"+!flag);
		}
	}
	@Test
	public void test02()
	{
		String s="%³¬%";
		List<Film> fi=fd.getAllFilms(s);
		if(fi.size()>0)
		{
			for(Film f:fi)
			{
				System.out.println(f.getName());
			}
		}
		else
		{
			System.out.println("lll");
		}
	}
}
