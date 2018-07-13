package cn.bean;

public class BookList {
	private int id;
	private int user_id;
	private int film_id;
	private String number;
	private String booktime;
	private String showtime;
	private int cinema_id;
	private int theater_id;
	private int seat_id;
	private int paystatus;
	public BookList(int user_id, int film_id, String number, String booktime, int cinema_id, int theater_id, int seat_id,
			int paystatus, String showtime) {
		super();
		this.user_id = user_id;
		this.film_id = film_id;
		this.number = number;
		this.booktime = booktime;
		this.cinema_id = cinema_id;
		this.theater_id = theater_id;
		this.seat_id = seat_id;
		this.paystatus = paystatus;
		this.showtime = showtime;
	}
	public BookList(int id, int user_id, int film_id, String number, String booktime, int cinema_id, int theater_id,
			int seat_id, int paystatus, String showtime) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.film_id = film_id;
		this.number = number;
		this.booktime = booktime;
		this.cinema_id = cinema_id;
		this.theater_id = theater_id;
		this.seat_id = seat_id;
		this.paystatus = paystatus;
		this.showtime = showtime;
	}
	public BookList() {
		super();
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getBooktime() {
		return booktime;
	}
	public void setBooktime(String booktime) {
		this.booktime = booktime;
	}
	public int getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(int cinema_id) {
		this.cinema_id = cinema_id;
	}
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public String getShowtime()
	{
		return showtime;
	}
	public void setShowtime(String showtime)
	{
		this.showtime = showtime;
	}
}
