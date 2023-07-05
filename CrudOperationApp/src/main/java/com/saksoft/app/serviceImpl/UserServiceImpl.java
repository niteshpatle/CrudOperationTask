package com.saksoft.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saksoft.app.model.User;
import com.saksoft.app.repository.UserRepository;
import com.saksoft.app.service.UserService;

import jakarta.transaction.Transactional;

@Service
//@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		User user1=userRepository.save(user);
		return user1;
	}

	@Override
	public List<User> fetchAllUsers() {
			List<User> userList=userRepository.findAll();
			return userList;
	}

	@Override
	public User fetchUserById(int id) {
		Optional<User> userData=userRepository.findById(id);
		if(userData.isPresent()) {
			User user=userData.get();
			return user;
		}
		return null;
	
	}

	@Override
	public User updateUser(User user, int id) {
		Optional<User> userdata=userRepository.findById(id);
		if(userdata.isPresent()) {
			User user1=userdata.get();
				user1.setFirstName(user.getFirstName());
				user1.setLastName(user.getLastName());
				user1.setEmail(user.getEmail());
				user1.setAge(user.getAge());
				return user1;
		}
		return null;
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	
	

}
