package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.User;
import com.project.repos.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public List<User> listAll()
	{
		return repo.findAll();
	}
	public void addUser(User user)
	{
		repo.save(user);
	}
	public User get(Integer id)
	{
		return repo.findById(id).get();
	}
	public User login(User user) {
       
        if (user.getName() != null && !user.getName().isEmpty() &&
            user.getPassword() != null && !user.getPassword().isEmpty()) {
            System.out.println("User logged in: " + user.getName());
            return user;
        } else {
            System.out.println("Login failed for user: " + user.getName());
            return null;
        }
    }

    public boolean logOut() {
       
        System.out.println("User logged out");
        return true; 
    }
    
    
    public User updateUser(User updatedUser) {
        
         User existingUser = repo.findById(updatedUser.getId()).orElse(null);
         if (existingUser != null) {
             existingUser.setName(updatedUser.getName());
             existingUser.setType(updatedUser.getType());
             existingUser.setPassword(updatedUser.getPassword());
            repo.save(existingUser);
             return existingUser;
         } else {
             return null; // or throw an exception, handle according to your business logic
         }
    }
	
}