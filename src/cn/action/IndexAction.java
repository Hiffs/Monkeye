package cn.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Film;
import cn.dao.FilmDao;
import cn.dao.ImgDao;
import cn.dao.impl.FilmDaoImpl;
import cn.dao.impl.ImgDaoImpl;
import cn.framework.Action;

public class IndexAction implements Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		FilmDao fd=new FilmDaoImpl();
		ImgDao ida=new ImgDaoImpl();
		List<Film> films=fd.getAllFilms(0,8);
		Map<Integer, String> iPath=new HashMap<>();
		for(Film f:films)
		{
			String ip=ida.getPathById(f.getCover_id());
			iPath.put(f.getId(),ip);
		}
		request.setAttribute("films",films);
		request.setAttribute("iPath",iPath);
		return "index.jsp";
	}

}
