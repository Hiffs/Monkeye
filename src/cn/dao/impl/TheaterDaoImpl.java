package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Theater;
import cn.dao.TheaterDao;
import cn.dbc.Base;

public class TheaterDaoImpl implements TheaterDao {

	Base base=new Base();
	@Override
	public List<Theater> getAllTheaterByCinema_id(int cinema_id) {
		String sql="select * from theater where cinema_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(cinema_id);
		List<Theater> theaters=base.getQuery(sql, list, Theater.class);
		return theaters;
	}

	@Override
	public Theater getTheaterById(int id) {
		String sql="select * from theater where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<Theater> theaters=base.getQuery(sql, list, Theater.class);
		return theaters.get(0);
	}

}
