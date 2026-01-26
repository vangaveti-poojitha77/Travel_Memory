package com.example.travel_memoriess.model;

public class User{
	private int userId;
	private String name;
	private String Address;
	private int memory_table_id;
	private String password;
	
	public int getUserId() {
		return userId;
	}
	public User(int userId, String name, String address, int memory_table_id, String password) {
		super();
		this.userId = userId;
		this.name = name;
		Address = address;
		this.memory_table_id = memory_table_id;
		this.password = password;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getMemory_table_id() {
		return memory_table_id;
	}
	public void setMemory_table_id(int memory_table_id) {
		this.memory_table_id = memory_table_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

