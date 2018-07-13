package cn.bean;

public class Comment {
	private int id;
	private int film_id;
	private int user_id;
	private String content;
	private String time;
	public Comment(int film_id, int user_id, String content, String time) {
		super();
		this.film_id = film_id;
		this.user_id = user_id;
		this.content = content;
		this.time = time;
	}
	public Comment(int id, int film_id, int user_id, String content, String time) {
		super();
		this.id = id;
		this.film_id = film_id;
		this.user_id = user_id;
		this.content = content;
		this.time = time;
	}
	public Comment() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
