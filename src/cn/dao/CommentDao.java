package cn.dao;

import java.util.List;

import cn.bean.Comment;

public interface CommentDao {
	//��ʾĳ����Ӱ�µ���������
	List<Comment> showAllCommentsByFilm_id(int Film_id);

	//���ݵ�ǰuser_idд���ۣ���Ҫ���µ��������������ݺ�ʱ��
	boolean writeComments(Comment comment);
}
