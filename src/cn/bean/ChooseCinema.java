package cn.bean;

public class ChooseCinema {
	private int id;
	private String area;
	public ChooseCinema() {
		super();
	}
	public ChooseCinema(int id, String area) {
		super();
		this.id = id;
		this.area = area;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
}
