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
import cn.dao.CinemaDao;
import cn.dao.impl.CinemaDaoImpl;
import cn.framework.Action;
import cn.util.PageBean;

public class CinemaAction implements Action
{
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
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
				chooseCinema.setId(Integer.parseInt(sstr[1].split("&")[0]));
				if(sstr.length==3) {
					try {
						sstr[2]=URLDecoder.decode(sstr[2], "utf-8");
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					}
					chooseCinema.setArea(sstr[2]);
				}
			}
		}
		int id=chooseCinema.getId();
		String area=chooseCinema.getArea();
		if(id==0&&area.equals("zero")) {
			pb = new PageBean(cinemas.size(), pageIndex, 3);
			newCinemas=cinemaDao.showAllCinema(pb.getStartIndex(), pb.getPageSize());
		}else if(id==0&&(!area.equals("zero"))){
			newCinemas=cinemaDao.getCinemaByLocation(area);
			pb = new PageBean(newCinemas.size(), pageIndex, 3);
		} else if(cinemaDao.getCinemaByIdAndLOcation(id, area)!=null) {
			newCinemas.add(cinemaDao.getCinemaByIdAndLOcation(id, area));
			pb = new PageBean(newCinemas.size(), pageIndex, 3);
		}
		request.setAttribute("id", id);
		request.setAttribute("aarea", area);
		request.setAttribute("areas", areas);
		request.setAttribute("pageBean", pb);
		request.setAttribute("cinemas", cinemas);
		request.setAttribute("newCinemas", newCinemas);
		return "cinema.jsp";
	}

}
