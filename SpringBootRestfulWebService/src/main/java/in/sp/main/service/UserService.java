package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import in.sp.main.entities.User;

public interface UserService {

	public User createUser(User user);
	
	public List<User> getAllUser();
	public Optional<User> getUserDetails(int id);
	
	public User upateUserDetails(int id,User user);//id for user and user for value
	
	public void deleteUser(int id) ;
	
}
