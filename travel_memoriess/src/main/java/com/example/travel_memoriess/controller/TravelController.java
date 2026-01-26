package com.example.travel_memoriess.controller;

//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.travel_memoriess.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.travel_memoriess.service.MemoryService;
import com.example.travel_memoriess.model.Memory;


import com.example.travel_memoriess.model.User;
import java.util.*;

@RestController
class TravelController{
	@Autowired
	public TravelService travelservice;
	@Autowired
	public MemoryService memoryservice;
	@GetMapping("/travel")
	public ArrayList<User> getUsers() {
		return travelservice.getUsers() ;
	}
	@GetMapping("/travel/{userId}")
	public User getUserById(@PathVariable("userId") int userId) {
		return travelservice.getUserById(userId);
	}
	@PutMapping("/travel/{userId}")
	public User updateUser(@RequestBody User user,@PathVariable("userId") int userId) {
		return travelservice.updateUser(user,userId);
	}
	@PostMapping("/travel")
	public User addUser(@RequestBody User user) {
		return travelservice.addUser(user);
	}
	@DeleteMapping("/travel/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		travelservice.deleteUser(userId);
	}
	@GetMapping("/travel/memories")
	public ArrayList<Memory> getMemories(){
		return memoryservice.getMemories();
	}
	@GetMapping("travel/memories/country/{country}")
	public ArrayList<Memory> getMemoriesByCountry(@PathVariable("country") String country){
		String country1=country.toLowerCase();
		return memoryservice.getMemoriesByCountry(country1);
	}
	@GetMapping("travel/memories/user/{userId}")
	public ArrayList<Memory> getMemoriesByUserId(@PathVariable("userId") int userId){
		return memoryservice.getMemoriesByUserId(userId);
	}
	@GetMapping("travel/memories/state/{state}")
	public ArrayList<Memory> getMemoriesByState(@PathVariable("state") String state){
		String state1=state.toLowerCase();
		return memoryservice.getMemoriesByState(state1);
	}
	@GetMapping("travel/memories/allStates/user/{userId}")
	public List<String> getStatesByUser(@PathVariable("userId") int userId){
		return memoryservice.getStatesByUser(userId);
	}
	@GetMapping("travel/memories/userSummary/user/{userId}")
	public List<Map<String,Object>> getUserSummary(@PathVariable("userId") int userId){
		return memoryservice.getUserSummary(userId);
	}
	@GetMapping("travel/memories/id/{memoryId}")
	 public Memory getMemoryById(@PathVariable("memoryId") int memoryId) {
		return memoryservice.getMemoryById(memoryId);
	}
	@GetMapping("travel/memories/budget/{budget}")
	public ArrayList<Memory> getMemoryByBudget(@PathVariable("budget") int budget) {
		return memoryservice.getMemoryByBudget(budget);
	}
	
}



