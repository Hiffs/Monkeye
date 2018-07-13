package cn.bean;

public class FilmType {
	private int id;
	private int type_id;
	private int movie_id;
	public FilmType(int id, int type_id, int movie_id) {
		super();
		this.id = id;
		this.type_id = type_id;
		this.movie_id = movie_id;
	}
	public FilmType() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
}
