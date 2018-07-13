package cn.dao;

import java.util.List;

public interface FilmActorDao {
	
	//通过演员Id获取电影的id集合
	List<Integer> getFilm_idByActor_id(int Actor_id);
	
	//通过电影的id获取演员的Id集合
	List<Integer> getActor_idByFilm_id(int Film_id);
}
