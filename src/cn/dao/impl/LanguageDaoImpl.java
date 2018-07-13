package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Language;
import cn.dao.LanguageDao;
import cn.dbc.Base;

public class LanguageDaoImpl implements LanguageDao{

	Base base=new Base();
	@Override
	public String getLanguageByLanguage_id(int language_id) {
		String sql="select * from Language where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(language_id);
		List<Language> language=base.getQuery(sql, list, Language.class);
		if(language.size()>0) {
			return language.get(0).getLanguage();
		}
		return null;
	}

}
