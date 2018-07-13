package cn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.bean.Comment;
import cn.dao.CommentDao;
import cn.dbc.Base;

public class CommentDaoImpl implements CommentDao {

	Base base=new Base();
	@Override
	public List<Comment> showAllCommentsByFilm_id(int Film_id) {
		String sql="select * from comment where film_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(Film_id);
		List<Comment> comments=base.getQuery(sql, list, Comment.class);
		return comments;
	}

	@Override
	public boolean writeComments(Comment comment) {
		String sql="insert into comment(film_id,user_id,content,time) values(?,?,?,?)";
		List<Object> list=new ArrayList<Object>();
		list.add(comment.getFilm_id());
		list.add(comment.getUser_id());
		list.add(comment.getContent());
		list.add(comment.getTime());
		return base.getUpdate(sql, list);
	}

}
