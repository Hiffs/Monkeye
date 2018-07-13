package cn.dao;

import java.util.List;

import cn.bean.Film;

public interface FilmTypeDao {
	//通过电影id获取类型id的集合
	List<Integer> getType_idByFilm_id(int film_id);
	
	//通过类型id获取电影id的集合
	List<Integer> getFilm_idByType_id(int type_id);
	
	List<Film> getFilmByTypeId(int type_id);
}
