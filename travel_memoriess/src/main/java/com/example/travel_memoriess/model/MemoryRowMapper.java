package com.example.travel_memoriess.model;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException; 
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;

public class MemoryRowMapper implements RowMapper<Memory>{
	@Override
	public Memory mapRow(ResultSet rs,int rowNum) throws SQLException {
		return new Memory(
				rs.getInt("id"),
				 rs.getInt("user_id"),
				 rs.getString("location"),
				 rs.getString("state"),
				 rs.getString("country"),
				 rs.getDouble("latitude"),
				 rs.getDouble("longitude"),
				 rs.getString("photos"),
				 rs.getString("friends_visited"),
				 rs.getDouble("distance_from_user_location"),
				 rs.getDouble("budget"),
				 rs.getString("special_moments"),
				 rs.getInt("days_spent"),
				 rs.getDate("start_date"),
				 rs.getDate("end_date"),
				 rs.getNString("famous_food")
				 
				);	
				
	}
	
	
}