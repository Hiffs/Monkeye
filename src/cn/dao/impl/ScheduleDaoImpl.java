package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Schedule;
import cn.dao.ScheduleDao;
import cn.dbc.Base;

public class ScheduleDaoImpl implements ScheduleDao {

	Base base=new Base();
	@Override
	public List<Schedule> getAllScheduleByCinema_id(int cinema_id) {
		String sql="select * from schedule where cinema_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(cinema_id);
		List<Schedule> schedules=base.getQuery(sql, list, Schedule.class);
		if(schedules.size()>0){
			return schedules;
		}
		return null;
	}

	@Override
	public List<Schedule> getAllScheduleByFilm_id(int film_id) {
		String sql="select * from schedule where film_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(film_id);
		List<Schedule> schedules=base.getQuery(sql, list, Schedule.class);
		if(schedules.size()>0){
			return schedules;
		}
		return null;
	}

	@Override
	public List<Schedule> getScheduleByCinema_idAndTheater_id(int cinema_id, int theater_id) {
		String sql="select * from schedule where cinema_id=? and theater_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(cinema_id);
		list.add(theater_id);
		List<Schedule> schedules=base.getQuery(sql, list, Schedule.class);
		if(schedules.size()>0){
			return schedules;
		}
		return null;
	}

	@Override
	public Schedule getScheduleById(int id)
	{
		String sql="select * from schedule where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<Schedule> schedules=base.getQuery(sql, list, Schedule.class);
		if(schedules.size()>0){
			return schedules.get(0);
		}
		return null;
	}

}
