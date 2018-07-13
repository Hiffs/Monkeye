package cn.dao;

import java.util.List;

import cn.bean.Comment;

public interface CommentDao {
	//显示某部电影下的所有评论
	List<Comment> showAllCommentsByFilm_id(int Film_id);

	//根据当前user_id写评论，需要更新的内容是评论内容和时间
	boolean writeComments(Comment comment);
}
