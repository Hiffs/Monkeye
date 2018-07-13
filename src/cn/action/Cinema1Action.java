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
	 * ���ܴ���ӰƬid
	 * ����ӰԺid--->��Ƭid�����֣���ַ���绰������
	 * ��Ƭid--->Ӱ��id����ӳʱ�䣬ӰƬid���ۼ�
	 * ӰƬid--->���֣�ʱ��������id��ͼƬid
	 * ӰƬid--->��Ӱ���ͱ�-->���ͣ�ȡһ����
	 * ӰƬid--->��Ӱ��Ա��-->��Աid
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
		
		//����ӰԺ
		Cinema cinema = cinemaDao.getCinemaById(cinemaId);
		
		Set<Film> filmSet = new HashSet<Film>();
		List<String> filmImg = new ArrayList<String>();
		List<String> filmLan = new ArrayList<String>();
		List<String> filmType = new ArrayList<String>();
		List<String> filmActor = new ArrayList<String>();
		List<String> theater = new ArrayList<String>();
		
		List<Schedule> scheduleList = scheduleDao.getAllScheduleByCinema_id(cinemaId);
		for(Schedule s : scheduleList)
		{   //��Ӱ
			filmSet.add(filmDao.getFilmById(s.getFilm_id()));
			Theater th = theaterDao.getTheaterById(s.getTheater_id());
			String thName = th.getName();
			theater.add(thName.substring(thName.length()-1, thName.length()));
		}
		for(Film f : filmSet)
		{
			movies++;
			//��Ӱ����
			filmImg.add(imgDao.getPathById(f.getCover_id()));
			//��Ӱ����
			filmType.add(typeDao.getNameById(filmtypeDao.getType_idByFilm_id(f.getId()).get(0)));
			//��Ӱ����
			filmLan.add(languageDao.getLanguageByLanguage_id(f.getLanguage_id()));
			//��Ӱ��Ա
			List<Integer> filmActorId = filmActorDao.getActor_idByFilm_id(f.getId());
			StringBuffer actorName = new StringBuffer();
			for(int i = 0; i < filmActorId.size(); i++)
			{
				if(i == 3) break; //ÿ����Ӱȡ����Ա����������3
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
