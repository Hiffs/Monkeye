package cn.bean;

public class Img {
	private int id;
	private String imgpath;
	private String desc;
	public Img() 
	{
		super();
	}
	public Img(int id, String imgpath, String desc)
	{
		super();
		this.id = id;
		this.imgpath = imgpath;
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImPath() {
		return imgpath;
	}
	public void setImgPath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
}
