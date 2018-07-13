package cn.dao;

import java.util.List;

public interface FilmDirectorDao {
	//通过电影id获取director的id集合
	List<Integer> getDirector_idByFilm_id(int film_id);
	
	//通过Director的id获取电影id的集合
	List<Integer> getFilm_idByDirector_id(int director_id);
}
