package cn.dao;

import java.util.List;

import cn.bean.Theater;

public interface TheaterDao {
	//通过影院id找到所有的影厅
	public List<Theater> getAllTheaterByCinema_id(int cinema_id);
	
	//通过影厅id找到相应的影厅信息
	public Theater getTheaterById(int id);
}
