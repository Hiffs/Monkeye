package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Film;
import cn.bean.FilmType;
import cn.dao.FilmTypeDao;
import cn.dbc.Base;

public class FilmTypeDaoImpl implements FilmTypeDao {

	Base base=new Base();
	@Override
	public List<Integer> getType_idByFilm_id(int film_id) {
		String sql="select * from FilmType where movie_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(film_id);
		List<FilmType> filmTypes=base.getQuery(sql, list, FilmType.class);
		List<Integer> nums=new ArrayList<Integer>();
		for(int i=0;i<filmTypes.size();i++) {
			nums.add(filmTypes.get(i).getType_id());
		}
		return nums;
	}

	@Override
	public List<Integer> getFilm_idByType_id(int type_id) {
		String sql="select * from FilmType where type_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(type_id);
		List<FilmType> filmTypes=base.getQuery(sql, list, FilmType.class);
		List<Integer> nums=new ArrayList<Integer>();
		for(int i=0;i<filmTypes.size();i++) {
			nums.add(filmTypes.get(i).getMovie_id());
		}
		return nums;
	}

	@Override
	public List<Film> getFilmByTypeId(int type_id)
	{
		List<Film> lf = new ArrayList<Film>();
		String sql = "select f.* from film f, filmtype ft WHERE f.id = ft.movie_id AND ft.type_id = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(type_id);
		lf = base.getQuery(sql, list, Film.class);
		return lf;
	}

}
