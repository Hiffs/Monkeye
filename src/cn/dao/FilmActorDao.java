package cn.dao;

import java.util.List;

public interface FilmActorDao {
	
	//ͨ����ԱId��ȡ��Ӱ��id����
	List<Integer> getFilm_idByActor_id(int Actor_id);
	
	//ͨ����Ӱ��id��ȡ��Ա��Id����
	List<Integer> getActor_idByFilm_id(int Film_id);
}
