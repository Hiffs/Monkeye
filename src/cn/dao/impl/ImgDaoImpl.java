package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Img;
import cn.dao.ImgDao;
import cn.dbc.Base;

public class ImgDaoImpl implements ImgDao {

	Base base=new Base();
	@Override
	public String getPathById(int id) {
		String sql="select * from Img where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<Img> imgs=base.getQuery(sql, list, Img.class);
		if(imgs.size()>0) {
			return imgs.get(0).getImPath();
		}
		else {
			return null;
		}
	}

}
