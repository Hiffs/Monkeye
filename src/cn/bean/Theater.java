package cn.bean;

public class Theater {
	private int id;
	private String name;
	private int size;
	private int cinema_id;
	public Theater(int id, String name, int size, int cinema_id) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.cinema_id = cinema_id;
	}
	public Theater() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(int cinema_id) {
		this.cinema_id = cinema_id;
	}
}
