package cn.dao;

import java.util.List;

import cn.bean.Theater;

public interface TheaterDao {
	//ͨ��ӰԺid�ҵ����е�Ӱ��
	public List<Theater> getAllTheaterByCinema_id(int cinema_id);
	
	//ͨ��Ӱ��id�ҵ���Ӧ��Ӱ����Ϣ
	public Theater getTheaterById(int id);
}
