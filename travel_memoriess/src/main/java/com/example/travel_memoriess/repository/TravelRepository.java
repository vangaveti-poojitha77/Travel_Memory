
package com.example.travel_memoriess.repository;
import com.example.travel_memoriess.model.User;
import java.util.*;

 public interface TravelRepository{
	 ArrayList<User>getUsers();
	 User getUserById(int userId);
	 User updateUser(User user,int userId);
	 User addUser(User user);
	 void deleteUser(int userId);
 }