package cn.bean;

public class Schedule {
	private int id;
	private int cinema_id;
	private int theater_id;
	private String showtime;
	private int film_id;
	private int price;
	public Schedule(int id, int cinema_id, int theater_id, String showtime, int film_id, int price) {
		super();
		this.id = id;
		this.cinema_id = cinema_id;
		this.theater_id = theater_id;
		this.showtime = showtime;
		this.film_id = film_id;
		this.price = price;
	}
	public Schedule() {
		super();
	}
	public int getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(int cinema_id) {
		this.cinema_id = cinema_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
}
