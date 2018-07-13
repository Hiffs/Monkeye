package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Cinema;
import cn.dao.CinemaDao;
import cn.dbc.Base;

public class CinemaDaoImpl implements CinemaDao {

	Base base=new Base();
	@Override
	public List<Cinema> showAllCinema() {
		String sql="select * from cinema";
		List<Object> list=new ArrayList<Object>();
		List<Cinema> cinemas=base.getQuery(sql, list, Cinema.class);
		return cinemas;
	}

	@Override
	public List<Cinema> showAllCinema(int startIndex, int pageSize)
	{
		String sql="select * from cinema limit ?,?";
		List<Object> list=new ArrayList<Object>();
		list.add(startIndex);
		list.add(pageSize);
		List<Cinema> cinemas=base.getQuery(sql, list, Cinema.class);
		return cinemas;
	}
	
	@Override
	public Cinema getCinemaByName(String name) {
		String sql="select * from Cinema where name=?";
		List<Object> list=new ArrayList<Object>();
		list.add(name);
		List<Cinema> cinemas=base.getQuery(sql, list, Cinema.class);
		if(cinemas.size()>0) {
			return cinemas.get(0);
		}
		return null;
	}

	@Override
	public Cinema getCinemaById(int id) {
		String sql="select * from Cinema where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<Cinema> cinemas=base.getQuery(sql, list, Cinema.class);
		if(cinemas.size()>0) {
			return cinemas.get(0);
		}
		return null;
	}

	@Override
	public List<Cinema> getCinemaByLocation(String area) {
		List<Cinema> allCinema=showAllCinema();
		String location=null;
		List<Cinema> cinemas=new ArrayList<Cinema>();
		Cinema cinema=null;
		for(int i=0;i<allCinema.size();i++) {
			String sql="select * from Cinema where location=?";
			List<Object> list=new ArrayList<Object>();
			location=allCinema.get(i).getLocation();
			if(location.substring(0,location.indexOf("Çø")+1).equals(area)) {
				list.add(location);
			}else {
				list.add("");
			}
			if(base.getQuery(sql, list, Cinema.class).size()>0) {
				cinema=(Cinema) base.getQuery(sql, list, Cinema.class).get(0);
				cinemas.add(cinema);
			}
		}
		if(cinemas.size()>0) {
			return cinemas;
		}
		return null;
	}
	
	@Override
	public Cinema getCinemaByIdAndLOcation(int id, String area) {
		Cinema cinema=getCinemaById(id);
		String location="";
		if(cinema==null) {
			location="zero";
		}else {
			location=cinema.getLocation();
		}
		if(area.equals("zero")) {
			return cinema;
		}
		if(location.substring(0, location.indexOf("Çø")+1).equals(area)) {
			return cinema;
		}
		return null;
	}
}
