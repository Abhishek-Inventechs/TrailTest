package com.javatpoint.server.main.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserResource 
{
@Autowired
private UserDaoService service;
@GetMapping("/users")
public List<User> retriveAllUsers()
{
return service.findAll();
}
//retrieves a specific user detail
@GetMapping("/users/{id}")
public User retriveUser(@PathVariable int id)
{
return service.findOne(id);
}
//method that posts a new user detail 
@PostMapping("/users")
public void createUser(@RequestBody User user)
{
User sevedUser=service.save(user);	
}

@PutMapping("/users")
public void update(@RequestBody User user)
{
	User saved = service.save(user);
}
@DeleteMapping("/users/{id}")
public Map<String, Boolean> delete(@PathVariable int id)
{
	User delete = service.findOne(id);
	Map<String, Boolean> response = new HashMap<>();
	 response.put("deleted", Boolean.TRUE);
	 return response; 
}
}