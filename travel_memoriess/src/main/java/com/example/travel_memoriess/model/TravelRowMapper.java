package com.example.travel_memoriess.model;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException; 

public class TravelRowMapper implements RowMapper<User>{
	@Override
	public User mapRow(ResultSet rs,int rowNum) throws SQLException {
		return new User(
				rs.getInt("id"),
				 rs.getString("name"),
				rs.getString("location"),
				rs.getInt("memory_table_id"),
				rs.getString("password")
				);
				
	}
}