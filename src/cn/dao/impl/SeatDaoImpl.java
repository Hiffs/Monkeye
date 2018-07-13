package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Seat;
import cn.dao.SeatDao;
import cn.dbc.Base;

public class SeatDaoImpl implements SeatDao
{
	Base base = new Base();
	@Override
	public List<Seat> getAllSeat()
	{
		String sql = "select * from seat";
		List<Object> list = new ArrayList<Object>();
		List<Seat> li = new ArrayList<Seat>();
		li = base.getQuery(sql, list, Seat.class);
		return li;
	}
	@Override
	public boolean bookSeat(int seatid, int theaterid, int time, int status)
	{
		boolean flag = false;
		String sql = "update seat set status = ? where seat_id=? and theater_id = ? and time = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(status);
		list.add(seatid);
		list.add(theaterid);
		list.add(time);
		flag = base.getUpdate(sql, list);
		return false;
	}

}
