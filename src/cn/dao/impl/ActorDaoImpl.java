package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Actor;
import cn.dao.ActorDao;
import cn.dbc.Base;

public class ActorDaoImpl implements ActorDao {
	Base base=new Base();
	
	@Override
	public String findActorById(int id) {
		String sql="select * from actor where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<Actor> actors=base.getQuery(sql, list, Actor.class);
		return actors.get(0).getActor();
	}

	@Override
	public int findIdByActor(String actor) {
		String sql="select * from actor where actor=?";
		List<Object> list=new ArrayList<Object>();
		list.add(actor);
		List<Actor> actors=base.getQuery(sql, list, Actor.class);
		return actors.get(0).getId();
	}

	@Override
	public Actor getActorById(int id) {
		String sql="select * from actor where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		Actor actor=(Actor) base.getQuery(sql, list, Actor.class).get(0);
		return actor;
	}
}
