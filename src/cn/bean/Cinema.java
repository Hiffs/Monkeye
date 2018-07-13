package cn.bean;

public class Cinema {
	private int id;
	private String name;
	private String location;
	private String tel;
	private int img_id;
	public Cinema(int id, String name, String location, String tel, int img_id) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.tel = tel;
		this.img_id = img_id;
	}
	public Cinema() {
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
}
