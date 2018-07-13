package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Type;
import cn.dao.TypeDao;
import cn.dbc.Base;

public class TypeDaoImpl implements TypeDao {

	Base base=new Base();
	@Override
	public String getNameById(int id) {
		String sql="select * from Type where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(id);
		List<Type> types=base.getQuery(sql, list, Type.class);
		if(types.size()>0) {
			return types.get(0).getName();
		}
		return null;
	}

	@Override
	public int getIdByName(String name) {
		String sql="select * from Type where name=?";
		List<Object> list=new ArrayList<Object>();
		list.add(name);
		List<Type> types=base.getQuery(sql, list, Type.class);
		if(types.size()>0) {
			return types.get(0).getId();
		}
		return 0;
	}

	@Override
	public List<Type> getAllType()
	{
		List<Type> lt = null;
		String sql = "select * from type";
		List<Object> list = new ArrayList<Object>();
		lt = base.getQuery(sql, list, Type.class);
		return lt;
	}

}
