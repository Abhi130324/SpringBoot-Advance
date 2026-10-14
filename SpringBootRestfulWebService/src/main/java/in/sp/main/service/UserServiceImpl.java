package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.User;
import in.sp.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User createUser(User user) {//this method will save user object in database
		
		
		return userRepository.save(user);
	}


	@Override
	public List<User> getAllUser() {
	
		return 	userRepository.findAll();
	}


	@Override
	public Optional<User> getUserDetails(int id) {
		
		return userRepository.findById(id);
	}


	@Override
	public User upateUserDetails(int id, User newUser) {
		User userData = userRepository.findById(id).orElse(null);
		if(userData != null) {
			return userRepository.save(newUser);
		}
	 throw new RuntimeException("User not Found with id : "+id);
	}


	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

}
