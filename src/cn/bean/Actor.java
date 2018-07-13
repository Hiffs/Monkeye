package cn.bean;

public class Actor {

	private int id;
	private String actor;
	private String path;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Actor(int id, String actor, String path) {
		super();
		this.id = id;
		this.actor = actor;
		this.path = path;
	}
	public Actor() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
}
