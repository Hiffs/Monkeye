package cn.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.*;
import cn.dao.*;
import cn.dao.impl.*;
import cn.framework.Action;

public class ConfigPayAction implements Action
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

	/*
	 * userid
	 * seatList
	 * scheid
	 * filmid
	 * theaterid
	 * cinemaid
	 * booklistnum
	 * 
	 */
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		String bookListNum = "2";
		if(request.getParameter("booklist") != null)
			bookListNum = request.getParameter("booklist");
		BookList booklist = booklistDao.showBookListByNum(bookListNum);
		booklist.setPaystatus(1);
		booklistDao.UpdateBookListById(booklist);
		
		int scheid = 1;
		if(request.getParameter("scheid") != null)
			scheid = Integer.parseInt(request.getParameter("scheid"));
		Schedule sche = scheduleDao.getScheduleById(scheid);
		
		Film f = filmDao.getFilmById(sche.getFilm_id());
		Cinema cinema = cinemaDao.getCinemaById(sche.getCinema_id());
		Theater theater = theaterDao.getTheaterById(sche.getTheater_id());
		String[] showtime = new String[4];
		showtime[0] = sche.getShowtime().substring(5, 6);
		showtime[1] = sche.getShowtime().substring(7, 9);
		showtime[2] = sche.getShowtime().substring(10, 12);
		showtime[3] = sche.getShowtime().substring(13, 15);
		
//		String[] seatListO = request.getParameter("seatlist").split(",");
//		String[] seatList = new String[seatListO.length - 1];
//		for(int i = 0; i < seatListO.length - 1; i++)
//		{
//			int seatid = Integer.parseInt(seatListO[i+1]);
//			seatList[i] = getSeat(seatid);
//		}
		
		
		request.setAttribute("filmName", f);
		request.setAttribute("cinemaName", cinema);
		request.setAttribute("theater", theater.getName().substring(theater.getName().length() - 1));
		request.setAttribute("showtime", showtime);
//		request.setAttribute("seatList", seatList);
		
		return "configpay.jsp";
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

}
