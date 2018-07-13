package cn.bean;

public class FilmActor {
	private int id;
	private int actor_id;
	private int film_id;
	public FilmActor(int id, int actor_id, int film_id) {
		super();
		this.id = id;
		this.actor_id = actor_id;
		this.film_id = film_id;
	}
	public FilmActor() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
}
