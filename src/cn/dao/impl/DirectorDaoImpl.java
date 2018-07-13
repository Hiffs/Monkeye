package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Director;
import cn.dao.DirectorDao;
import cn.dbc.Base;

public class DirectorDaoImpl implements DirectorDao {

	Base base=new Base();
	@Override
	public int getIdByDirector(String director) {
		String sql="select * from director where director=?";
		List<Object> list=new ArrayList<Object>();
		list.add(director);
		List<Director> directors=base.getQuery(sql, list, Director.class);
		return directors.get(0).getId();
	}

	@Override
	public String getDirectorById(int id) {
		String sql="select * from director where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<Director> director=base.getQuery(sql, list, Director.class);
		return director.get(0).getDirector();
	}

	@Override
	public Director findDirectorById(int id) {
		String sql="select * from director where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		Director director= (Director) base.getQuery(sql, list, Director.class).get(0);
		return director;
	}

}
