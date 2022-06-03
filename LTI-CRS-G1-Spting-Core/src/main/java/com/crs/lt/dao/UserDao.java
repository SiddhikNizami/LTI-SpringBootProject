package com.crs.lt.dao;

import java.util.List;
import java.util.UUID;

import com.crs.lt.beans.User;
import com.crs.lt.constants.Role;


public interface UserDao {

	User getUser(String username);
	List<User> getAllUser();
	List<User> getAllStudentUser();
	void saveUser(User user);
	public List<User> getStudentById(List<UUID> studentIds);
}
