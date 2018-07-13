package cn.dao;

import java.util.List;

public interface FilmImgDao {
	//通过film_id获取图片的id集合
	public List<Integer> getImg_idByFilm_id(int film_id);
}
