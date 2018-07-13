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
	//���ݿ����Ӳ���
	@Test
	public void test01(){
		String sql="select * from user";
		List<Object> list=new ArrayList<Object>();
		List<User> users=new Base().getQuery(sql, list, User.class);
		for(int i=0;i<users.size();i++) {
			System.out.println(users.get(i).getName());
		}
	}
	
	//����Actor��ķ�����ʵ��
	@Test
	public void test02() {
		ActorDao actorDao=new ActorDaoImpl();
		System.out.println(actorDao.findActorById(1));
		System.out.println(actorDao.findIdByActor("Chris Hemsworth"));
	}
	
	//����BookList��ķ�����ʵ��
	@Test
	public void test03() {
		BookListDao bookListDao=new BookListDaoImpl();
		List<BookList> bookLists=bookListDao.showAllBookListByUser_id(1);
		System.out.println("-----------��ѯ���ж���----------");
		for(int i=0;i<bookLists.size();i++) {
			System.out.println(bookLists.get(i).getBooktime());
			BookList book=bookListDao.showBookListById(bookLists.get(i).getId());
			System.out.println("----------ͨ��id���Ҷ����͵�Ӱid��--------");
			System.out.println(book.getBooktime());
			System.out.println(bookListDao.getFilm_idById(bookLists.get(i).getId()));
		}
		BookList bookList=new BookList(1, 1, 1, "2", "2018-05-28 11:23:44", 1, 1, 1, 1, "sss");
		BookList bookList1=bookListDao.UpdateBookListById(bookList);
		System.out.println("-----------��ѯ�Ƿ���¶���-------------------");
		System.out.println(bookList1.getNumber());
/*		BookList bookList2=new BookList(1, 1, 3, "2018-05-28 11:23:55", 1, 1, 1, 1);
		BookList bookList3=bookListDao.addBookList(bookList2);
		System.out.println("------------�鿴�Ƿ������鼮------------------");
		System.out.println(bookList3.getBooktime());*/
		System.out.println("---------�ж���λ�Ƿ�Ԥ��------");
		System.out.println(bookListDao.isSeatBought(1, 1));
	}
	
	//����cinema��������
	@Test
	public void test04() {
		CinemaDao cinemaDao=new CinemaDaoImpl();
		List<Cinema> cinemas=cinemaDao.showAllCinema();
		for(int i=0;i<cinemas.size();i++) {
			System.out.println(cinemas.get(i).getLocation());
		}
		Cinema cinema=cinemaDao.getCinemaByName("����Ӱ��");
		System.out.println(cinema.getLocation());
	}
	
	//�������۵ķ�����ʵ����
	@Test
	public void test05() {
		CommentDao commentDao=new CommentDaoImpl();
		List<Comment> comments=commentDao.showAllCommentsByFilm_id(1);
		for(int i=0;i<comments.size();i++) {
			System.out.println(comments.get(i).getContent());
		}
		Comment comment=new Comment(1, 1, "�ٴιۿ����о����Ǻܰ�", "2018-05-28 11:35:55");
		if(commentDao.writeComments(comment)) {
			List<Comment> commentss=commentDao.showAllCommentsByFilm_id(1);
			for(int i=0;i<commentss.size();i++) {
				System.out.println(commentss.get(i).getContent());
			}
		}
	}
	
	//���Ե�����ķ���
	@Test
	public void test06() {
		DirectorDao directorDao=new DirectorDaoImpl();
		System.out.println(directorDao.getDirectorById(1));
		System.out.println(directorDao.getIdByDirector("Τ��"));
	}
	
	//���Ե�Ӱ��ķ���
	@Test
	public void test07() {
		FilmDao filmDao=new FilmDaoImpl();
		List<Film> films=filmDao.getAllFilms();
		for(int i=0;i<films.size();i++) {
			System.out.println(films.get(i).getName());
		}
		int id=filmDao.getFilm_idByName("��ʱ��ͬ��");
		System.out.println(id);
		Film film=filmDao.getFilmById(id);
		System.out.println(film.getName()+film.getContent());
	}
	
	//������Աid�͵�Ӱid�Ķ�Զ��ϵ
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
	
	//���Ե���id�͵�Ӱid�Ķ�Թ�ϵ
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
	
	//���Ե�Ӱ��ͼƬһ�Զ�Ĺ�ϵ
	@Test
	public void test10() {
		FilmImgDao filmImgDao=new FilmImgDaoImpl();
		List<Integer> nums=filmImgDao.getImg_idByFilm_id(1);
		for(int i=0;i<nums.size();i++) {
			System.out.println(nums.get(i));
		}
	}
	
	//���Ե�Ӱ���Ӱ���Ͷ�Զ�Ĺ�ϵ
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
	
	//����ͼƬ·���࣬����·��
	@Test
	public void test12() {
		ImgDao imgDao=new ImgDaoImpl();
		System.out.println(imgDao.getPathById(1));
	}
	
	//������������
	@Test
	public void test13() {
		LanguageDao languageDao=new LanguageDaoImpl();
		System.out.println(languageDao.getLanguageByLanguage_id(5));
	}
	
	//������Ƭ��
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
	
	//����Ӱ����
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
	
	
	//��������
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
