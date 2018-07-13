package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.FilmActor;
import cn.dao.FilmActorDao;
import cn.dbc.Base;

public class FilmActorDaoImpl implements FilmActorDao{

	Base base=new Base();
	@Override
	public List<Integer> getFilm_idByActor_id(int Actor_id) {
		String sql="select * from filmactor where actor_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(Actor_id);
		List<FilmActor> filmActor=base.getQuery(sql, list, FilmActor.class);
		List<Integer> nums=new ArrayList<Integer>();
		for(int i=0;i<filmActor.size();i++) {
			nums.add(filmActor.get(i).getFilm_id());
		}
		return nums;
	}

	@Override
	public List<Integer> getActor_idByFilm_id(int Film_id) {
		String sql="select * from filmactor where Film_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(Film_id);
		List<FilmActor> filmActor=base.getQuery(sql, list, FilmActor.class);
		List<Integer> nums=new ArrayList<Integer>();
		for(int i=0;i<filmActor.size();i++) {
			nums.add(filmActor.get(i).getActor_id());
		}
		return nums;
	}

}
