package cn.bean;

public class Director {
	private int id;
	private String director;
	private String path;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Director(int id, String director, String path) {
		super();
		this.id = id;
		this.director = director;
		this.path = path;
	}
	public Director() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
}
