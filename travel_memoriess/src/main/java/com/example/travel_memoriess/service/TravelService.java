package com.example.travel_memoriess.service;
import com.example.travel_memoriess.repository.TravelRepository;
import com.example.travel_memoriess.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.travel_memoriess.model.TravelRowMapper;
import java.util.*;

import java.security.MessageDigest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.dao.EmptyResultDataAccessException;



@Service
public class TravelService implements TravelRepository{
	@Autowired
	private JdbcTemplate db;
	public ArrayList<User> getUsers(){
		List<User> userlist=db.query("select * from users",new TravelRowMapper());
		ArrayList<User> users=new ArrayList<>(userlist);
		return users;
	}
	public User getUserById(int userId) {
		try {
		User user=db.queryForObject("select * from users where id=?", new TravelRowMapper(),userId);
		return user;
		}
		
			
		catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Please Recheck Userid,UserId Not Found");
		    }
		
		
		}
		
	
	
	public static String sha256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		
		
    }
	
	

	public User updateUser(User user,int userId) {
		//byte[] varbinaryData = 
//		System.out.println(varbinaryData);
		//return  varbinaryData;
		
		
		
		 String varbinaryData=sha256(user.getPassword());
    
		if(user.getName()!=null) {
		db.update("update users set name=? where id=?",user.getName(),userId);}
		if(user.getAddress()!=null) {
			db.update("update users set location=? where id=?",user.getAddress(),userId);}
		if(user.getMemory_table_id()!=-1) {
			db.update("update users set memory_table_id=? where id=?",user.getMemory_table_id(),userId);
			}
		if(user.getPassword()!=null) {
			db.update("update users set password=? where id=?",varbinaryData,userId);
		}
		
		User user1=db.queryForObject("select * from users where name=? and location=? and memory_table_id=? and password=? ",new TravelRowMapper(),user.getName(),user.getAddress(),user.getMemory_table_id(),varbinaryData);
		return user1;
		
	}
	public User addUser(User user) {
		String varbinaryData=sha256(user.getPassword());
		db.update("insert into users(name,location,memory_table_id,password)values(?,?,?,?)",user.getName(),user.getAddress(),user.getMemory_table_id(),varbinaryData);
		User user1=db.queryForObject("select * from users where name=? and location=? and memory_table_id=?",new TravelRowMapper(), user.getName(),user.getAddress(),user.getMemory_table_id());
		return user1;
		
	}
	public void deleteUser(int userId) {
		
		
	
		
			db.update("delete from users where id=?",userId);
			
		}
		
		

}
