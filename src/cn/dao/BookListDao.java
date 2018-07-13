package cn.dao;

import java.util.List;
import cn.bean.BookList;

public interface BookListDao {
	
	//ͨ������IDչʾ������Ϣ
	List<BookList> showAllBookListByUser_id(int user_id); 
	
	//���Ӷ���
	boolean addBookList(BookList bookList);
	
	//ͨ��id��ȡ������Ϣ
	BookList showBookListById(int id);
	
	//ɾ������
	boolean deleteBookListById(int id);
	
	//�޸Ķ�����Ϣ������֧��״̬
	BookList UpdateBookListById(BookList bookList);
	
	//��ȡ��Ӱid
	int getFilm_idById(int id);
	
	//�ж���λ�Ƿ��Ѿ���Ԥ��
	boolean isSeatBought(int seat_id,int user_id);
	
	//���ݶ����Ų�ѯ����
	BookList showBookListByNum(String number);
	
}
