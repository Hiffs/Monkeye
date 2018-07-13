package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Avavtar;
import cn.dao.AvatarDao;
import cn.dbc.Base;

public class AvatarDaoImpl implements AvatarDao
{
	Base base=new Base();
	@Override
	public String getaPathById(int id)
	{
		String sql="select * from Avatar where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<Avavtar> avatars=base.getQuery(sql, list, Avavtar.class);
		if(avatars.size()>0) {
			return avatars.get(0).getPath();
		}
		else {
			return null;
		}
	}

}
