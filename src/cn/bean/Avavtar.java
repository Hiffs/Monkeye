package cn.bean;

public class Avavtar
{
	private int id;
	private String path;
	private String desc;
	public Avavtar()
	{
		super();
	}
	public Avavtar(int id, String path, String desc)
	{
		super();
		this.id = id;
		this.path = path;
		this.desc = desc;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
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
