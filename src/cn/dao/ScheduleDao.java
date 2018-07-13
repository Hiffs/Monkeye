package cn.dao;

import java.util.List;

import cn.bean.Schedule;

public interface ScheduleDao {
	//通过电影院获取所有的排片信息
	List<Schedule> getAllScheduleByCinema_id(int cinema_id);
	
	//通过电影id获取所有的排片信息
	List<Schedule> getAllScheduleByFilm_id(int film_id);
	
	//获得一个一天影院的排片时间
	List<Schedule> getScheduleByCinema_idAndTheater_id(int cinema_id,int theater_id);

	//根据id获取具体排片信息
	Schedule getScheduleById(int id);
}
