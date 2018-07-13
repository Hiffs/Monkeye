package cn.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.*;
import cn.dao.impl.*;
import cn.bean.*;
import cn.framework.Action;

public class PayAction implements Action
{

	CinemaDao cinemaDao = new CinemaDaoImpl();
	FilmDao filmDao = new FilmDaoImpl();
	ImgDao imgDao = new ImgDaoImpl();
	FilmTypeDao filmtypeDao = new FilmTypeDaoImpl();
	FilmActorDao filmActorDao = new FilmActorDaoImpl();
	ScheduleDao scheduleDao = new ScheduleDaoImpl();
	TypeDao typeDao = new TypeDaoImpl();
	LanguageDao languageDao = new LanguageDaoImpl();
	ActorDao actorDao = new ActorDaoImpl();
	TheaterDao theaterDao = new TheaterDaoImpl();
	BookListDao booklistDao = new BookListDaoImpl();
	SeatDao seatDao = new SeatDaoImpl();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		/*
		 * seatlist
    	 * userid
    	 * filmid
    	 * scheid
    	 * booktime
    	 * time1
		 */
		int time1 = 1;
		if(request.getParameter("time1") != null)
		{
			time1 = Integer.parseInt(request.getParameter("time1"));
		}
		
		String booktime;
		int userid = 1, scheid = 0;
		int booklistid = 1;
		if(request.getParameter("uesrid") != null)
			userid = Integer.parseInt(request.getParameter("userid"));
		if(request.getParameter("scheid") != null)
			scheid = Integer.parseInt(request.getParameter("scheid"));
		if(request.getParameter("booktime") != null)
			booktime = request.getParameter("booktime");
		else
			booktime = new Date(new java.util.Date().getTime()).toString();
		
		String tot_price = request.getParameter("tot_price");
		
		Schedule sche = scheduleDao.getScheduleById(scheid);
		String[] seatListO = request.getParameter("seatlist").split(",");
		//×ùÎ»
		String number = getNumber();
		String[] seatList = new String[seatListO.length - 1];
		for(int i = 0; i < seatListO.length - 1; i++)
		{
			int seatid = Integer.parseInt(seatListO[i+1]);
			BookList booklist = new BookList(userid, sche.getFilm_id(), number, booktime, sche.getCinema_id(), sche.getTheater_id(), seatid, 0, sche.getShowtime());
			booklistDao.addBookList(booklist);
			seatDao.bookSeat(seatid, sche.getTheater_id(), time1, 1);
			seatList[i] = getSeat(seatid);
		}
		
		Film f = filmDao.getFilmById(sche.getFilm_id());
		Theater thea = theaterDao.getTheaterById(sche.getTheater_id());
		Cinema cinema = cinemaDao.getCinemaById(sche.getCinema_id());
		String[] showtime = new String[4];
		showtime[0] = sche.getShowtime().substring(5, 6);
		showtime[1] = sche.getShowtime().substring(7, 9);
		showtime[2] = sche.getShowtime().substring(10, 12);
		showtime[3] = sche.getShowtime().substring(13, 15);
		
		request.setAttribute("filmName", f);
		request.setAttribute("theaterName", thea.getName().substring(thea.getName().length()-1));
		request.setAttribute("cinemaName", cinema);
		request.setAttribute("seatList", seatList);
		request.setAttribute("showtime", showtime);
		request.setAttribute("sche", sche);
		request.setAttribute("booklist", number);
		request.setAttribute("price", tot_price);
		
		return "pay.jsp";
	}

	public String getSeat(int seatId)
	{
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
	
	public String getNumber()
	{
		SimpleDateFormat simpleDateFormat;
		simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		java.util.Date d = new java.util.Date();
		String str = simpleDateFormat.format(d);
		Random random = new Random();
		int rannum = (int) (random.nextDouble()*(99999 - 10000 + 1))+ 10000;
		return str + rannum;
	}
}
