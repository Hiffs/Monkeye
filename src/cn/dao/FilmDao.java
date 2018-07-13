package cn.dao;

import java.util.List;

import cn.bean.Film;

public interface FilmDao {
	//ͨ����Ӱ����ȡ��ӰId
	int getFilm_idByName(String name);
	
	//ͨ����Ӱid��ȡ��Ӱ��Ϣ
	Film getFilmById(int id);
	
	//��ȡȫ���ĵ�Ӱ��Ϣ
	List<Film> getAllFilms();
	
	List<Film> getAllFilms(int startIndex, int pageSize);
	
	//ģ����ѯ
	List<Film> getAllFilms(String str); 
}

