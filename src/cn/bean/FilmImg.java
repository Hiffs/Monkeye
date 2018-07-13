package cn.bean;

public class FilmImg {
	private int id;
	private int film_id;
	private int img_id;
	public FilmImg(int id, int film_id, int img_id) {
		super();
		this.id = id;
		this.film_id = film_id;
		this.img_id = img_id;
	}
	public FilmImg() {
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
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
}
