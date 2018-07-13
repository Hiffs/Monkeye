package cn.bean;

public class Seat {
	private int id;
	private int seat_id;
	private int theater_id;
	private int time;
	private int status;
	public Seat(int id, int seat_id, int theater_id, int time, int status) {
		super();
		this.id = id;
		this.seat_id = seat_id;
		this.theater_id = theater_id;
		this.time = time;
		this.status = status;
	}
	public Seat() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
