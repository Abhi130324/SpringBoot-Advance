package in.sp.main.services;

import in.sp.main.entities.User;

public interface UserService {

	public boolean registerUser(User user);//if user register success value true else false
	
	public User loginUser(String email, String Password);
}
