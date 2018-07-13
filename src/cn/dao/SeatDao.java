package cn.dao;

import java.util.List;

import cn.bean.Seat;

public interface SeatDao
{
	//查询所有座位
	List<Seat> getAllSeat();
	
	boolean bookSeat(int seatid, int theaterid, int time, int status);
}
