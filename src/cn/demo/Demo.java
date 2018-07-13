package cn.demo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import cn.bean.BookList;
import cn.bean.Cinema;
import cn.bean.Comment;
import cn.bean.Film;
import cn.bean.Schedule;
import cn.bean.Theater;
import cn.bean.User;
import cn.dao.ActorDao;
import cn.dao.BookListDao;
import cn.dao.CinemaDao;
import cn.dao.CommentDao;
import cn.dao.DirectorDao;
import cn.dao.FilmActorDao;
import cn.dao.FilmDao;
import cn.dao.FilmDirectorDao;
import cn.dao.FilmImgDao;
import cn.dao.FilmTypeDao;
import cn.dao.ImgDao;
import cn.dao.LanguageDao;
import cn.dao.ScheduleDao;
import cn.dao.TheaterDao;
import cn.dao.TypeDao;
import cn.dao.impl.ActorDaoImpl;
import cn.dao.impl.BookListDaoImpl;
import cn.dao.impl.CinemaDaoImpl;
import cn.dao.impl.CommentDaoImpl;
import cn.dao.impl.DirectorDaoImpl;
import cn.dao.impl.FilmActorDaoImpl;
import cn.dao.impl.FilmDaoImpl;
import cn.dao.impl.FilmDirectorDaoImpl;
import cn.dao.impl.FilmImgDaoImpl;
import cn.dao.impl.FilmTypeDaoImpl;
import cn.dao.impl.ImgDaoImpl;
import cn.dao.impl.LanguageDaoImpl;
import cn.dao.impl.ScheduleDaoImpl;
import cn.dao.impl.TheaterDaoImpl;
import cn.dao.impl.TypeDaoImpl;
import cn.dbc.Base;

public class Demo {
	//数据库连接测试
	@Test
	public void test01(){
		String sql="select * from user";
		List<Object> list=new ArrayList<Object>();
		List<User> users=new Base().getQuery(sql, list, User.class);
		for(int i=0;i<users.size();i++) {
			System.out.println(users.get(i).getName());
		}
	}
	
	//测试Actor类的方法与实现
	@Test
	public void test02() {
		ActorDao actorDao=new ActorDaoImpl();
		System.out.println(actorDao.findActorById(1));
		System.out.println(actorDao.findIdByActor("Chris Hemsworth"));
	}
	
	//测试BookList类的方法和实现
	@Test
	public void test03() {
		BookListDao bookListDao=new BookListDaoImpl();
		List<BookList> bookLists=bookListDao.showAllBookListByUser_id(1);
		System.out.println("-----------查询所有订单----------");
		for(int i=0;i<bookLists.size();i++) {
			System.out.println(bookLists.get(i).getBooktime());
			BookList book=bookListDao.showBookListById(bookLists.get(i).getId());
			System.out.println("----------通过id查找订单和电影id号--------");
			System.out.println(book.getBooktime());
			System.out.println(bookListDao.getFilm_idById(bookLists.get(i).getId()));
		}
		BookList bookList=new BookList(1, 1, 1, "2", "2018-05-28 11:23:44", 1, 1, 1, 1, "sss");
		BookList bookList1=bookListDao.UpdateBookListById(bookList);
		System.out.println("-----------查询是否跟新订单-------------------");
		System.out.println(bookList1.getNumber());
/*		BookList bookList2=new BookList(1, 1, 3, "2018-05-28 11:23:55", 1, 1, 1, 1);
		BookList bookList3=bookListDao.addBookList(bookList2);
		System.out.println("------------查看是否增加书籍------------------");
		System.out.println(bookList3.getBooktime());*/
		System.out.println("---------判断座位是否被预定------");
		System.out.println(bookListDao.isSeatBought(1, 1));
	}
	
	//测试cinema各个方法
	@Test
	public void test04() {
		CinemaDao cinemaDao=new CinemaDaoImpl();
		List<Cinema> cinemas=cinemaDao.showAllCinema();
		for(int i=0;i<cinemas.size();i++) {
			System.out.println(cinemas.get(i).getLocation());
		}
		Cinema cinema=cinemaDao.getCinemaByName("金逸影城");
		System.out.println(cinema.getLocation());
	}
	
	//测试评论的方法和实现类
	@Test
	public void test05() {
		CommentDao commentDao=new CommentDaoImpl();
		List<Comment> comments=commentDao.showAllCommentsByFilm_id(1);
		for(int i=0;i<comments.size();i++) {
			System.out.println(comments.get(i).getContent());
		}
		Comment comment=new Comment(1, 1, "再次观看，感觉还是很棒", "2018-05-28 11:35:55");
		if(commentDao.writeComments(comment)) {
			List<Comment> commentss=commentDao.showAllCommentsByFilm_id(1);
			for(int i=0;i<commentss.size();i++) {
				System.out.println(commentss.get(i).getContent());
			}
		}
	}
	
	//测试导演类的方法
	@Test
	public void test06() {
		DirectorDao directorDao=new DirectorDaoImpl();
		System.out.println(directorDao.getDirectorById(1));
		System.out.println(directorDao.getIdByDirector("韦正"));
	}
	
	//测试电影类的方法
	@Test
	public void test07() {
		FilmDao filmDao=new FilmDaoImpl();
		List<Film> films=filmDao.getAllFilms();
		for(int i=0;i<films.size();i++) {
			System.out.println(films.get(i).getName());
		}
		int id=filmDao.getFilm_idByName("超时空同居");
		System.out.println(id);
		Film film=filmDao.getFilmById(id);
		System.out.println(film.getName()+film.getContent());
	}
	
	//测试演员id和电影id的多对多关系
	@Test
	public void test08() {
		FilmActorDao filmActorDao=new FilmActorDaoImpl();
		List<Integer> actors=filmActorDao.getActor_idByFilm_id(1);
		for(int i=0;i<actors.size();i++) {
			System.out.println(actors.get(i));
		}
		List<Integer> films=filmActorDao.getFilm_idByActor_id(12);
		for(int i=0;i<films.size();i++) {
			System.out.println(films.get(i));
		}
	}
	
	//测试导演id和电影id的多对关系
	@Test
	public void test09() {
		FilmDirectorDao filmDirectorDao=new FilmDirectorDaoImpl();
		List<Integer> director_ids=filmDirectorDao.getDirector_idByFilm_id(1);
		for(int i=0;i<director_ids.size();i++) {
			System.out.println(director_ids.get(i));
		}
		List<Integer> filmDirectors=filmDirectorDao.getFilm_idByDirector_id(1);
		for(int i=0;i<filmDirectors.size();i++) {
			System.out.println(filmDirectors.get(i));
		}
	}
	
	//测试电影与图片一对多的关系
	@Test
	public void test10() {
		FilmImgDao filmImgDao=new FilmImgDaoImpl();
		List<Integer> nums=filmImgDao.getImg_idByFilm_id(1);
		for(int i=0;i<nums.size();i++) {
			System.out.println(nums.get(i));
		}
	}
	
	//测试电影与电影类型多对多的关系
	@Test
	public void test11() {
		FilmTypeDao filmTypeDao=new FilmTypeDaoImpl();
		List<Integer> nums=filmTypeDao.getFilm_idByType_id(3);
		for(int i=0;i<nums.size();i++) {
			System.out.println(nums.get(i));
		}
		List<Integer> numss=filmTypeDao.getType_idByFilm_id(1);
		for(int i=0;i<numss.size();i++) {
			System.out.println(numss.get(i));
		}
	}
	
	//测试图片路径类，查找路径
	@Test
	public void test12() {
		ImgDao imgDao=new ImgDaoImpl();
		System.out.println(imgDao.getPathById(1));
	}
	
	//测试语言类型
	@Test
	public void test13() {
		LanguageDao languageDao=new LanguageDaoImpl();
		System.out.println(languageDao.getLanguageByLanguage_id(5));
	}
	
	//测试排片类
	@Test
	public void test14() {
		ScheduleDao scheduleDao=new ScheduleDaoImpl();
		List<Schedule> schedules=scheduleDao.getAllScheduleByCinema_id(1);
		for(int i=0;i<schedules.size();i++) {
			System.out.println(schedules.get(i).getShowtime());
		}
		System.out.println("----------------------------");
		List<Schedule> schedules1=scheduleDao.getScheduleByCinema_idAndTheater_id(1, 1);
		for(int i=0;i<schedules1.size();i++) {
			System.out.println(schedules1.get(i).getShowtime());
		}
		System.out.println("-----------------------------");
		List<Schedule> schedules2=scheduleDao.getAllScheduleByFilm_id(1);
		for(int i=0;i<schedules2.size();i++) {
			System.out.println(schedules2.get(i).getShowtime());
		}
	}
	
	//测试影厅类
	@Test
	public void test15() {
		TheaterDao theaterDao=new TheaterDaoImpl();
		List<Theater> theaters=theaterDao.getAllTheaterByCinema_id(1);
		for(int i=0;i<theaters.size();i++) {
			System.out.println(theaters.get(i).getName());
		}
		Theater theater=theaterDao.getTheaterById(1);
		System.out.println(theater.getName());
	}
	
	
	//测试类型
	@Test
	public void test16() {
		TypeDao typeDao=new TypeDaoImpl();
		System.out.println(typeDao.getNameById(11));
		System.out.println(typeDao.getIdByName("22"));
	}
	
	@Test
	public void test17() {
		FilmDao filmDao=new FilmDaoImpl();
		FilmActorDao filmActorDao=new FilmActorDaoImpl();
		FilmDirectorDao filmDirectorDao=new FilmDirectorDaoImpl();
		DirectorDao directorDao=new DirectorDaoImpl();
		ActorDao actorDao=new ActorDaoImpl();
		ImgDao imgDao=new ImgDaoImpl();
		int id=1;
		Film film=filmDao.getFilmById(id);
		List<Integer> actor_ids=filmActorDao.getActor_idByFilm_id(id);
		List<Integer> director_ids=filmDirectorDao.getDirector_idByFilm_id(id);
		List<String> actorNames=new ArrayList<String>();
		List<String> directorNames=new ArrayList<String>();
		for(int i=0;i<director_ids.size();i++) {
			directorNames.add(directorDao.getDirectorById(director_ids.get(i)));
			System.out.println(directorDao.getDirectorById(director_ids.get(i)));
		}
		for(int i=0;i<actor_ids.size();i++) {
			actorNames.add(actorDao.findActorById(actor_ids.get(i)));
			System.out.println(actorDao.findActorById(actor_ids.get(i)));
		}
		System.out.println(film.getCover_id());
		System.out.println(imgDao.getPathById(film.getCover_id()));
	}
}
