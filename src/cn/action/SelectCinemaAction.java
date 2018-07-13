package cn.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.bean.ChooseCinema;
import cn.bean.Cinema;
import cn.bean.Film;
import cn.dao.CinemaDao;
import cn.dao.FilmDao;
import cn.dao.FilmTypeDao;
import cn.dao.ImgDao;
import cn.dao.TypeDao;
import cn.dao.impl.CinemaDaoImpl;
import cn.dao.impl.FilmDaoImpl;
import cn.dao.impl.FilmTypeDaoImpl;
import cn.dao.impl.ImgDaoImpl;
import cn.dao.impl.TypeDaoImpl;
import cn.framework.Action;
import cn.util.PageBean;

public class SelectCinemaAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FilmDao filmDao=new FilmDaoImpl();
		TypeDao typeDao=new TypeDaoImpl();
		FilmTypeDao filmTypeDao=new FilmTypeDaoImpl();
		ImgDao imgDao=new ImgDaoImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		Film film=filmDao.getFilmById(id);
		List<Integer> type_ids=filmTypeDao.getType_idByFilm_id(id);
		List<String> types=new ArrayList<String>();
		for(int i=0;i<type_ids.size();i++) {
			types.add(typeDao.getNameById(type_ids.get(i)));
		}
		request.setAttribute("id", id);
		request.setAttribute("film", film);
		request.setAttribute("types", types);
		request.setAttribute("imgPath", imgDao.getPathById(film.getCover_id()));
		
		//--------------------------------------------------------------------------
		CinemaDao cinemaDao=new CinemaDaoImpl();
		List<Cinema> cinemas=cinemaDao.showAllCinema();
		List<Cinema> newCinemas=new ArrayList<Cinema>();
		PageBean pb = null;
		int pageIndex = 1;
		if(request.getParameter("pageIndex") != null)
			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		ChooseCinema chooseCinema=new ChooseCinema();
		chooseCinema.setId(0);
		chooseCinema.setArea("zero");
		Set<String> areas=new HashSet<String>();
		String str=request.getQueryString();
		String location=null;
		for(int i=0;i<cinemas.size();i++) {
			location=cinemas.get(i).getLocation();
			areas.add(location.substring(0, location.indexOf("Çø")+1));
		}
		if(str==null) {
			newCinemas=cinemaDao.showAllCinema();
		}else {
			String[] sstr=str.split("=");
			if(!sstr[0].equals("pageIndex")) {
				if(sstr[0].equals("id2")) {
					chooseCinema.setId(Integer.parseInt(request.getParameter("id2")));
				}
				if(sstr.length==4) {
					String[] ssstr=sstr[2].split("&");
					try {
						ssstr[0]=URLDecoder.decode(ssstr[0], "utf-8");
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					}
					chooseCinema.setArea(ssstr[0]);
				}
			}
		}
		int id2=chooseCinema.getId();
		String area=chooseCinema.getArea();
		if(id2==0&&area.equals("zero")) {
			pb = new PageBean(cinemas.size(), pageIndex, 3);
			newCinemas=cinemaDao.showAllCinema(pb.getStartIndex(), pb.getPageSize());
		}else if(id2==0&&(!area.equals("zero"))){
			newCinemas=cinemaDao.getCinemaByLocation(area);
			pb = new PageBean(newCinemas.size(), pageIndex, 3);
		} else if(cinemaDao.getCinemaByIdAndLOcation(id2, area)!=null) {
			newCinemas.add(cinemaDao.getCinemaByIdAndLOcation(id2, area));
			pb = new PageBean(newCinemas.size(), pageIndex, 3);
		}
		request.setAttribute("id2", id2);
		request.setAttribute("aarea", area);
		request.setAttribute("areas", areas);
		request.setAttribute("pageBean", pb);
		request.setAttribute("cinemas", cinemas);
		request.setAttribute("newCinemas", newCinemas);
		return "selectCinema.jsp";
	}

}
