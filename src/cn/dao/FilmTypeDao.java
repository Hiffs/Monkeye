package cn.dao;

import java.util.List;

import cn.bean.Film;

public interface FilmTypeDao {
	//ͨ����Ӱid��ȡ����id�ļ���
	List<Integer> getType_idByFilm_id(int film_id);
	
	//ͨ������id��ȡ��Ӱid�ļ���
	List<Integer> getFilm_idByType_id(int type_id);
	
	List<Film> getFilmByTypeId(int type_id);
}
