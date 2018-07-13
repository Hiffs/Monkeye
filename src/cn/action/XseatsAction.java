package cn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.*;
import cn.dao.*;
import cn.dao.impl.*;
import cn.framework.Action;

public class XseatsAction implements Action
{
	/*
	 * 传递排片id--->影院id,影厅id,上映时间,电影id,票价？
	 * 影厅id--->座位数
	 * 传递场次id+影厅id--->已售座位
	 * 电影id--->电影名
	 */
	TheaterDao theaterDao = new TheaterDaoImpl();
	ScheduleDao scheduleDao = new ScheduleDaoImpl();
	SeatDao seatDao = new SeatDaoImpl();
	FilmDao filmDao = new FilmDaoImpl();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		int scheduleId = 1;
		int time = 1;
		if(request.getParameter("schedule") != null)
		{
			scheduleId = Integer.parseInt(request.getParameter("schedule"));
		}
		if(request.getParameter("time") != null)
		{
			time = Integer.parseInt(request.getParameter("time"));
		}
		Schedule sche = scheduleDao.getScheduleById(scheduleId);
		int theaterSize = theaterDao.getTheaterById(sche.getTheater_id()).getSize();
		Film f = filmDao.getFilmById(sche.getFilm_id());
		List<Seat> seatList = seatDao.getAllSeat();
		StringBuffer soldSeat = new StringBuffer();
		for(Seat s : seatList)
		{
			if(s.getTheater_id() == sche.getTheater_id() && s.getTime() == time)
			{
				if(s.getStatus() == 1)
				{
					soldSeat.append(getSeat(s)+',');
				}
			}
		}
		request.setAttribute("filmName", f);
		request.setAttribute("theaterSize", theaterSize);
		request.setAttribute("sche", sche);
		request.setAttribute("soldSeat", soldSeat.substring(0));
		request.setAttribute("price", sche.getPrice());
		request.setAttribute("time1", time);
		return "xseats.jsp";
	}
	
	public String getSeat(Seat s)
	{
		int seatId = s.getSeat_id();
		int row = 1, col = 1;
		if(seatId <= 10)
		{
			row = 1; col = seatId;
		}
		else
		{
			row = seatId / 10 + 1;
			col = seatId % 10;
			if(col == 0)
			{
				col = 10; row -= 1;
			}
		}
		return row+"_"+col;
	}

}
