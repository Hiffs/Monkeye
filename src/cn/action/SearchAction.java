package cn.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Film;
import cn.dao.FilmDao;
import cn.dao.FilmTypeDao;
import cn.dao.ImgDao;
import cn.dao.TypeDao;
import cn.dao.impl.FilmDaoImpl;
import cn.dao.impl.FilmTypeDaoImpl;
import cn.dao.impl.ImgDaoImpl;
import cn.dao.impl.TypeDaoImpl;
import cn.framework.Action;

public class SearchAction implements Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		ImgDao ida=new ImgDaoImpl();
		FilmDao fd=new FilmDaoImpl();
		FilmTypeDao ftd=new FilmTypeDaoImpl();
		TypeDao td=new TypeDaoImpl();
		String search=request.getParameter("search").trim();
		String str="%"+search+"%";
		List<Film> film=fd.getAllFilms(str);
		Map<Integer,String> iPath=new HashMap<>();
		Map<Integer,String> aft=new HashMap<>();//
		if(film.size()>0)
		{
			for(Film f:film)
			{
				String ip=ida.getPathById(f.getCover_id());
				iPath.put(f.getId(),ip);
				List<Integer> typeList=ftd.getType_idByFilm_id(f.getId());
				String allType="";
				for(Integer i:typeList)
				{
					String type=td.getNameById(i);
					allType=allType+type+" ";
				}
				aft.put(f.getId(),allType);
			}
			request.setAttribute("fm",film);
			request.setAttribute("iPath",iPath);
			request.setAttribute("aft",aft);
		}
		else
		{
			String sd="很抱歉，没有找到相关的影视作品";
			request.setAttribute("sd",sd);
		}
		return "search.jsp";
	}

}
