package com.example.travel_memoriess.service;
import com.example.travel_memoriess.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.travel_memoriess.model.Memory;
import java.util.*;
import com.example.travel_memoriess.model.MemoryRowMapper;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;



@Service
public class MemoryService implements MemoryRepository{
	
	@Autowired
	private JdbcTemplate db;
	public ArrayList<Memory> getMemories(){
		List<Memory> memorylist=db.query("select * from memory",new MemoryRowMapper());
		ArrayList<Memory> memories=new ArrayList<>(memorylist);
		return memories;
		
	}
	
	public ArrayList<Memory> getMemoriesByCountry(String country){
		List<Memory> memorylist=db.query("select * from memory where LOWER(country)=?",new MemoryRowMapper(),country);
		ArrayList<Memory> memories=new ArrayList<>(memorylist);
		return memories; 
		
	}
	public ArrayList<Memory> getMemoriesByUserId(int userId){
	List<Memory> memorylist=db.query("select * from memory where user_id=?",new MemoryRowMapper(),userId);
	 ArrayList<Memory> memories=new ArrayList<>(memorylist);
	  return memories;
	} 
	public ArrayList<Memory> getMemoriesByState(String state){
		
		List<Memory> memorylist=db.query("select * from memory where LOWER(state)=?",new MemoryRowMapper(),state);
		
		 ArrayList<Memory> memories=new ArrayList<>(memorylist);
		  return memories;
	}
	
	public List<String> getStatesByUser(int userId) {
	    String sql = "SELECT DISTINCT state FROM memory WHERE user_id = ?";
	    //return jdbcTemplate.queryForList(sql, String.class, userId);
	    List<String> statelist=db.queryForList(sql,String.class,userId);
	    return statelist;
	}
	public List<String> getCountriesByUser(int userId) {
	    String sql = "SELECT DISTINCT state FROM memory WHERE user_id = ?";
	    //return jdbcTemplate.queryForList(sql, String.class, userId);
	    List<String> statelist=db.queryForList(sql,String.class,userId);
	    return statelist;
	}
	public List<Map<String,Object>> getUserSummary(int userId){
		String sql="SELECT country,Count(state) as no_of_states_travelled,COUNT(id) AS no_of_trips_travelled,SUM(budget) AS total_spent_on_all_trips,GROUP_CONCAT(DISTINCT famous_food) AS food_tried_in_all_trips,GROUP_CONCAT(DISTINCT friends_visited) as all_friends_travelled_with,sum(distance_from_user_location) as total_km_travelled_from_user_location,GROUP_CONCAT(DISTINCT special_moments) AS places_visited_in_trip FROM memory WHERE user_id = ? GROUP BY country";
		//String sql="select distinct country,state,Count(id) as trips_travelled,Sum(budget) as total_spent,famous_food as food_tried_in_all_trips from memory where userId=? groupby user_id";
		List<Map<String,Object>> userSummary=db.queryForList(sql,userId);
		return userSummary;
	}
	public Memory getMemoryById(int memoryId){
		Memory memory=db.queryForObject("select * from memory where id=?",new MemoryRowMapper(),memoryId);
		 
		  return memory;
	}
	
	public ArrayList<Memory> getMemoryByBudget(int budget) {
		List<Memory> memorylist=db.query("select * from memory where budget<?",new MemoryRowMapper(),budget);
		
		 ArrayList<Memory> memories=new ArrayList<>(memorylist);
		  return memories;
		
	}
	
} 