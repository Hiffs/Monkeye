package cn.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.*;
import cn.dao.*;
import cn.dao.impl.*;
import cn.framework.Action;

public class Cinema1Action implements Action
{
	/*
	 * 可能传递影片id
	 * 传递影院id--->排片id，名字，地址，电话，封面
	 * 排片id--->影厅id，上映时间，影片id，售价
	 * 影片id--->名字，时长，语言id，图片id
	 * 影片id--->电影类型表-->类型（取一个）
	 * 影片id--->电影演员表-->演员id
	 */
	
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
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		int cinemaId = 1;
		int movies = 0;
		if(request.getParameter("cinemaid") != null)
			cinemaId = Integer.parseInt(request.getParameter("cinemaid"));
		
		//传回影院
		Cinema cinema = cinemaDao.getCinemaById(cinemaId);
		
		Set<Film> filmSet = new HashSet<Film>();
		List<String> filmImg = new ArrayList<String>();
		List<String> filmLan = new ArrayList<String>();
		List<String> filmType = new ArrayList<String>();
		List<String> filmActor = new ArrayList<String>();
		List<String> theater = new ArrayList<String>();
		
		List<Schedule> scheduleList = scheduleDao.getAllScheduleByCinema_id(cinemaId);
		for(Schedule s : scheduleList)
		{   //电影
			filmSet.add(filmDao.getFilmById(s.getFilm_id()));
			Theater th = theaterDao.getTheaterById(s.getTheater_id());
			String thName = th.getName();
			theater.add(thName.substring(thName.length()-1, thName.length()));
		}
		for(Film f : filmSet)
		{
			movies++;
			//电影封面
			filmImg.add(imgDao.getPathById(f.getCover_id()));
			//电影类型
			filmType.add(typeDao.getNameById(filmtypeDao.getType_idByFilm_id(f.getId()).get(0)));
			//电影语言
			filmLan.add(languageDao.getLanguageByLanguage_id(f.getLanguage_id()));
			//电影演员
			List<Integer> filmActorId = filmActorDao.getActor_idByFilm_id(f.getId());
			StringBuffer actorName = new StringBuffer();
			for(int i = 0; i < filmActorId.size(); i++)
			{
				if(i == 3) break; //每部电影取出演员数量不大于3
				String name = actorDao.findActorById(filmActorId.get(i).intValue());
				actorName.append(name+",");
			}
			if(actorName.lastIndexOf(",") >= 0)
			{
				filmActor.add(actorName.substring(0, actorName.length()-1));
			}
		}
		
		request.setAttribute("movies", movies);
		request.setAttribute("cinema", cinema);
		request.setAttribute("filmSet", filmSet);
		request.setAttribute("filmImg", filmImg);
		request.setAttribute("filmType", filmType);
		request.setAttribute("filmLan", filmLan);
		request.setAttribute("filmActor", filmActor);
		request.setAttribute("scheduleList", scheduleList);
		request.setAttribute("theater", theater);
		
		return "cinema1.jsp";
	}
}
