package cn.dao;

import java.util.List;

import cn.bean.Cinema;

public interface CinemaDao {
	
	//չʾ���е�ӰԺ
	List<Cinema> showAllCinema();
	
	//��ҳչʾ����ӰԺ
	List<Cinema> showAllCinema(int startIndex, int pageSize);
	
	//ͨ��ӰԺ����ȡӰԺ��Ϣ
	Cinema getCinemaByName(String name);
	
	//ͨ����Ӱid��ȡ��Ӱ��Ϣ
	Cinema getCinemaById(int id);
	
	//����λ������ȡ��Ӱ��Ϣ
	List<Cinema> getCinemaByLocation(String area);
	
	//ͨ����Ӱid��λ����Ϣ��ȡ��Ӱ��Ϣ
	Cinema getCinemaByIdAndLOcation(int id,String area);
}
