package cn.dao;

import java.util.List;

import cn.bean.Seat;

public interface SeatDao
{
	//��ѯ������λ
	List<Seat> getAllSeat();
	
	boolean bookSeat(int seatid, int theaterid, int time, int status);
}
