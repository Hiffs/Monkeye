package cn.dao;

import java.util.List;

public interface FilmImgDao {
	//ͨ��film_id��ȡͼƬ��id����
	public List<Integer> getImg_idByFilm_id(int film_id);
}
