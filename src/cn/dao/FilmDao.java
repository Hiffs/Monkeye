package cn.dao;

import java.util.List;

import cn.bean.Film;

public interface FilmDao {
	//通过电影名获取电影Id
	int getFilm_idByName(String name);
	
	//通过电影id获取电影信息
	Film getFilmById(int id);
	
	//获取全部的电影信息
	List<Film> getAllFilms();
	
	List<Film> getAllFilms(int startIndex, int pageSize);
	
	//模糊查询
	List<Film> getAllFilms(String str); 
}

