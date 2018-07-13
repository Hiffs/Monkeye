package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Film;
import cn.dao.FilmDao;
import cn.dbc.Base;

public class FilmDaoImpl implements FilmDao {

	Base base=new Base();
	@Override
	public int getFilm_idByName(String name) {
		String sql="select * from film where name=?";
		List<Object> list=new ArrayList<Object>();
		list.add(name);
		List<Film> films=base.getQuery(sql, list, Film.class);
		return films.get(0).getId();
	}

	@Override
	public Film getFilmById(int id) {
		String sql="select * from film where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<Film> films=base.getQuery(sql, list, Film.class);
		return films.get(0);
	}

	@Override
	public List<Film> getAllFilms() {
		String sql="select * from film";
		List<Object> list=new ArrayList<Object>();
		return base.getQuery(sql, list, Film.class);
	}

	@Override
	public List<Film> getAllFilms(int startIndex, int pageSize)
	{
		String sql="select * from film limit ?,?";
		List<Object> list=new ArrayList<Object>();
		list.add(startIndex);
		list.add(pageSize);
		return base.getQuery(sql, list, Film.class);
	}

	@Override
	public List<Film> getAllFilms(String str)
	{
		String sql="select * from film where name like ?";
		List<Object> list=new ArrayList<Object>();
		list.add(str);
		return base.getQuery(sql, list, Film.class);
	}

}
