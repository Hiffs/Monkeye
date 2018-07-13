package cn.bean;

public class FilmDirector {
	private int id;
	private int director_id;
	private int film_id;
	public FilmDirector(int id, int director_id, int film_id) {
		super();
		this.id = id;
		this.director_id = director_id;
		this.film_id = film_id;
	}
	public FilmDirector() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDirector_id() {
		return director_id;
	}
	public void setDirector_id(int director_id) {
		this.director_id = director_id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
}
