package cn.dao;

import java.util.List;

public interface FilmDirectorDao {
	//ͨ����Ӱid��ȡdirector��id����
	List<Integer> getDirector_idByFilm_id(int film_id);
	
	//ͨ��Director��id��ȡ��Ӱid�ļ���
	List<Integer> getFilm_idByDirector_id(int director_id);
}
