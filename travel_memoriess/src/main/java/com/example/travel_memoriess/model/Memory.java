
package com.example.travel_memoriess.model;
import java.time.LocalDate;
import java.sql.Date;

public class Memory{
	private int id;
	private int user_id;
	private String location ;
	private String state;
	private String country;
	private double latitude ;
	private double longitude ;
	private String photos ;
	private String friends_visited;
	private double distance_from_user_location;
	private double budget;
	private String special_moments;
	private int days_spent;
	private Date start_date ;
	private Date end_date;
	private String famous_food;
	public Memory(int id, int user_id, String location, String state, String country, double latitude, double longitude,
			String photos, String friends_visited, double distance_from_user_location, double budget,
			String special_moments, int days_spent, Date start_date, Date end_date, String famous_food) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.location = location;
		this.state = state;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		this.photos = photos;
		this.friends_visited = friends_visited;
		this.distance_from_user_location = distance_from_user_location;
		this.budget = budget;
		this.special_moments = special_moments;
		this.days_spent = days_spent;
		this.start_date = start_date;
		this.end_date = end_date;
		this.famous_food = famous_food;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public String getFriends_visited() {
		return friends_visited;
	}
	public void setFriends_visited(String friends_visited) {
		this.friends_visited = friends_visited;
	}
	public double getDistance_from_user_location() {
		return distance_from_user_location;
	}
	public void setDistance_from_user_location(double distance_from_user_location) {
		this.distance_from_user_location = distance_from_user_location;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getSpecial_moments() {
		return special_moments;
	}
	public void setSpecial_moments(String special_moments) {
		this.special_moments = special_moments;
	}
	public int getDays_spent() {
		return days_spent;
	}
	public void setDays_spent(int days_spent) {
		this.days_spent = days_spent;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getFamous_food() {
		return famous_food;
	}
	public void setFamous_food(String famous_food) {
		this.famous_food = famous_food;
	}
	
	
	
}