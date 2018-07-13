package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.FilmDirector;
import cn.dao.FilmDirectorDao;
import cn.dbc.Base;

public class FilmDirectorDaoImpl implements FilmDirectorDao{

	Base base=new Base();
	@Override
	public List<Integer> getDirector_idByFilm_id(int film_id) {
		String sql="select * from filmdirector where film_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(film_id);
		List<FilmDirector> filmDirectors=base.getQuery(sql, list, FilmDirector.class);
		List<Integer> director_ids=new ArrayList<Integer>();
		for(int i=0;i<filmDirectors.size();i++) {
			director_ids.add(filmDirectors.get(i).getDirector_id());
		}
		return director_ids;
	}

	@Override
	public List<Integer> getFilm_idByDirector_id(int director_id) {
		String sql="select * from filmdirector where director_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(director_id);
		List<FilmDirector> filmDirectors=base.getQuery(sql, list, FilmDirector.class);
		List<Integer> film_ids=new ArrayList<Integer>();
		for(int i=0;i<filmDirectors.size();i++) {
			film_ids.add(filmDirectors.get(i).getFilm_id());
		}
		return film_ids;
	}

}
