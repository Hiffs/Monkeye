package cn.action;

import java.net.URLDecoder;
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
import cn.util.PageBean;

public class FilmAction implements Action
{
	TypeDao typeDao = new TypeDaoImpl();
	FilmDao filmDao = new FilmDaoImpl();
	FilmTypeDao filmTypeDao = new FilmTypeDaoImpl();
	ImgDao imgDao = new ImgDaoImpl();
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		User user=(User) request.getSession().getAttribute("user");
		//获取分页
		PageBean pb = null;
		int pageIndex = 1;
		if(request.getParameter("pageIndex") != null)
			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		
		//控制参量
		int typeid = 0;
		if(request.getParameter("typeid") != null)
		{
			typeid = Integer.parseInt(request.getParameter("typeid"));
		}
		String ttime = "0";
		if(request.getParameter("ttime") != null)
		{
			ttime = request.getParameter("ttime");
		}
		//获取所有类型，返回页面
		List<Type> types = typeDao.getAllType();
		
		//获取所有电影，返回作分页记录
		List<Film> films = filmDao.getAllFilms();
		
		//获取地区和年代数据，返回页面
		Set<String> areas = new HashSet<String>();
		Set<String> showTimes = new HashSet<String>();
		for(Film f : films)
		{
			areas.add(f.getArea());
			showTimes.add(f.getFilmtime_place().substring(0, 4));
		}
		//电影数据
		List<Film> newFilm = new ArrayList<Film>();
		List<String> cover = new ArrayList<String>();
		String aarea = "0";
		String str = request.getQueryString();
		if(str == null)
		{
			newFilm = films;
		}
		else
		{
			String[] sstr = str.split("&");
			if(sstr.length == 3)
			{
				try
				{
					aarea = URLDecoder.decode(sstr[1].split("=")[1], "utf-8");
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		
		if(typeid == 0 && aarea.equals("0") && ttime.equals("0"))
		{
			pb = new PageBean(films.size(), pageIndex, 10);
			newFilm = filmDao.getAllFilms(pb.getStartIndex(), pb.getPageSize());
			for(int i = 0; i < newFilm.size(); i++)
			{
				cover.add(imgDao.getPathById(newFilm.get(i).getCover_id()));
			}
		}
		else if(typeid == 0 && !aarea.equals("0") && ttime.equals("0"))
		{
			for(Film f : films)
			{
				if(f.getArea().equals(aarea))
				{
					newFilm.add(f);
					cover.add(imgDao.getPathById(f.getCover_id()));
				}
				pb = new PageBean(newFilm.size(), pageIndex, 10);
			}
		}
		else if(typeid != 0 && aarea.equals("0"))
		{
			newFilm = filmTypeDao.getFilmByTypeId(typeid);
			for(int i = 0; i < newFilm.size(); i++)
			{
				cover.add(imgDao.getPathById(newFilm.get(i).getCover_id()));
			}
			pb = new PageBean(newFilm.size(), pageIndex, 10);
		}
		
		request.setAttribute("types", types);
		request.setAttribute("typeid", typeid);
		request.setAttribute("areas", areas);
		request.setAttribute("aarea", aarea);
		request.setAttribute("showTimes", showTimes);
		request.setAttribute("ttime", ttime);
		request.setAttribute("newFilm", newFilm);
		request.setAttribute("cover", cover);
		request.setAttribute("pageBean", pb);
		return "films.jsp";
	}
	
}
