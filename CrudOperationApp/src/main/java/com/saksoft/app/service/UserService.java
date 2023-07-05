package com.saksoft.app.service;

import java.util.List;
import com.saksoft.app.model.User;

public interface UserService {

	public User addUser(User user);

	public List<User> fetchAllUsers();

	public User fetchUserById(int id) ;

	public User updateUser(User user, int id);

	public void deleteUser(int id);

}
