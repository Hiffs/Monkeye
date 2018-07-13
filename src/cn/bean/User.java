package cn.bean;

public class User {
	private int id;
	private int portrait_id;
	private String name;
	private String password;
	private String sex;
	private String phone;
	private String birth;
	private String marriage;
	private String job;
	private String interests;
	private String introduce;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPortrait_id() {
		return portrait_id;
	}
	public void setPortrait_id(int portrait_id) {
		this.portrait_id = portrait_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public User() {
		super();
	}
	public User(int id, int portrait_id, String name, String password, String sex, String phone, String birth,
			String marriage, String job, String interests, String introduce)
	{
		super();
		this.id = id;
		this.portrait_id = portrait_id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.birth = birth;
		this.marriage = marriage;
		this.job = job;
		this.interests = interests;
		this.introduce = introduce;
	}
}
