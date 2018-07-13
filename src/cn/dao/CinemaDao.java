package cn.dao;

import java.util.List;

import cn.bean.Cinema;

public interface CinemaDao {
	
	//展示所有的影院
	List<Cinema> showAllCinema();
	
	//分页展示所有影院
	List<Cinema> showAllCinema(int startIndex, int pageSize);
	
	//通过影院名获取影院信息
	Cinema getCinemaByName(String name);
	
	//通过电影id获取电影信息
	Cinema getCinemaById(int id);
	
	//根据位置来获取电影信息
	List<Cinema> getCinemaByLocation(String area);
	
	//通过电影id和位置信息获取电影信息
	Cinema getCinemaByIdAndLOcation(int id,String area);
}
