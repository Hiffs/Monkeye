package cn.dao;

import cn.bean.Actor;

public interface ActorDao {
	
	//ͨ��ID������Ա����Ҫ���ڵ�Ӱ���������Ա��Ϣ
	String findActorById(int id);
	
	//ͨ����Ա������ԱID,��Ҫ������Ա���ݹ��ĵ�Ӱ������
	int findIdByActor(String actor);
	
	Actor getActorById(int id);
}
