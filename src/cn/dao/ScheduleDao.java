package cn.dao;

import java.util.List;

import cn.bean.Schedule;

public interface ScheduleDao {
	//ͨ����ӰԺ��ȡ���е���Ƭ��Ϣ
	List<Schedule> getAllScheduleByCinema_id(int cinema_id);
	
	//ͨ����Ӱid��ȡ���е���Ƭ��Ϣ
	List<Schedule> getAllScheduleByFilm_id(int film_id);
	
	//���һ��һ��ӰԺ����Ƭʱ��
	List<Schedule> getScheduleByCinema_idAndTheater_id(int cinema_id,int theater_id);

	//����id��ȡ������Ƭ��Ϣ
	Schedule getScheduleById(int id);
}
