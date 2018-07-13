package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.FilmImg;
import cn.dao.FilmImgDao;
import cn.dbc.Base;

public class FilmImgDaoImpl implements FilmImgDao {

	Base base=new Base();
	@Override
	public List<Integer> getImg_idByFilm_id(int film_id) {
		String sql="select * from filmimg where film_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(film_id);
		List<FilmImg> filmimgs=base.getQuery(sql, list, FilmImg.class);
		List<Integer> nums=new ArrayList<Integer>();
		for(int i=0;i<filmimgs.size();i++) {
			nums.add(filmimgs.get(i).getImg_id());
		}
		return nums;
	}

}
