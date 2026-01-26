
package com.example.travel_memoriess.repository;
import java.util.*;
import com.example.travel_memoriess.model.Memory;

public interface MemoryRepository{
	ArrayList<Memory> getMemories();
	ArrayList<Memory> getMemoriesByCountry(String country);
	ArrayList<Memory> getMemoriesByUserId(int userId);
	ArrayList<Memory> getMemoriesByState(String state);
	List<String> getStatesByUser(int userId);
	List<Map<String,Object>> getUserSummary(int userId);
	 Memory getMemoryById(int memoryId);
	 ArrayList<Memory> getMemoryByBudget(int budget);
}