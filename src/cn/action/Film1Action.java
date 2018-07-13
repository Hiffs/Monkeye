package cn.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Actor;
import cn.bean.Comment;
import cn.bean.Director;
import cn.bean.Film;
import cn.dao.ActorDao;
import cn.dao.CommentDao;
import cn.dao.DirectorDao;
import cn.dao.FilmActorDao;
import cn.dao.FilmDao;
import cn.dao.FilmDirectorDao;
import cn.dao.FilmTypeDao;
import cn.dao.ImgDao;
import cn.dao.TypeDao;
import cn.dao.UserDao;
import cn.dao.impl.ActorDaoImpl;
import cn.dao.impl.CommentDaoImpl;
import cn.dao.impl.DirectorDaoImpl;
import cn.dao.impl.FilmActorDaoImpl;
import cn.dao.impl.FilmDaoImpl;
import cn.dao.impl.FilmDirectorDaoImpl;
import cn.dao.impl.FilmTypeDaoImpl;
import cn.dao.impl.ImgDaoImpl;
import cn.dao.impl.TypeDaoImpl;
import cn.dao.impl.UserDaoImpl;
import cn.framework.Action;

public class Film1Action implements Action {

	FilmDao filmDao=new FilmDaoImpl();
	FilmActorDao filmActorDao=new FilmActorDaoImpl();
	FilmDirectorDao filmDirectorDao=new FilmDirectorDaoImpl();
	DirectorDao directorDao=new DirectorDaoImpl();
	ActorDao actorDao=new ActorDaoImpl();
	TypeDao typeDao=new TypeDaoImpl();
	FilmTypeDao filmTypeDao=new FilmTypeDaoImpl();
	ImgDao imgDao=new ImgDaoImpl();
	CommentDao commentDao=new CommentDaoImpl();
	UserDao userDao=new UserDaoImpl();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int id=Integer.parseInt(request.getParameter("id"));
		Film film=filmDao.getFilmById(id);
		List<Integer> actor_ids=filmActorDao.getActor_idByFilm_id(id);
		List<Integer> director_ids=filmDirectorDao.getDirector_idByFilm_id(id);
		List<Integer> type_ids=filmTypeDao.getType_idByFilm_id(id);
		List<Comment> comments=commentDao.showAllCommentsByFilm_id(id);
		Map<String,String> showComments=new HashMap<String, String>();
		List<String> types=new ArrayList<String>();
		List<Actor> actors=new ArrayList<Actor>();
		List<Director> directors=new ArrayList<Director>();
		for(int i=0;i<comments.size();i++) {
			showComments.put(userDao.showUserById(comments.get(i).getUser_id()).getName(), comments.get(i).getContent());
		}
		for(int i=0;i<type_ids.size();i++) {
			types.add(typeDao.getNameById(type_ids.get(i)));
		}
		for(int i=0;i<director_ids.size();i++) {
			Director director=directorDao.findDirectorById(director_ids.get(i));
			directors.add(director);
		}
		for(int i=0;i<actor_ids.size();i++) {
			Actor actor=actorDao.getActorById(actor_ids.get(i));
			actors.add(actor);
		}
		request.setAttribute("comments",showComments);
		request.setAttribute("id", id);
		request.setAttribute("types", types);
		request.setAttribute("imgPath", imgDao.getPathById(film.getCover_id()));
		request.setAttribute("directors", directors);
		request.setAttribute("actors", actors);
		request.setAttribute("film", film);
		
		String content=(String) request.getAttribute("content");
//		String user_id=
		return "film.jsp";
	}
}
