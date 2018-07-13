package cn.dao;

import cn.bean.Actor;

public interface ActorDao {
	
	//通过ID查找演员，主要用在电影表中添加演员信息
	String findActorById(int id);
	
	//通过演员查找演员ID,主要用在演员表演过的电影搜索上
	int findIdByActor(String actor);
	
	Actor getActorById(int id);
}
