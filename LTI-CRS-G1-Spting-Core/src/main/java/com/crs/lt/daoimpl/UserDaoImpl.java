package com.crs.lt.daoimpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.crs.lt.beans.User;
import com.crs.lt.constants.DataCollections;
import com.crs.lt.constants.Role;
import com.crs.lt.dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUser(String username) {
		return DataCollections.users.stream()
				.filter(user->user.getUserName().equals(username)).findAny().orElse(null); 
	}

	@Override
	public List<User> getAllUser() {
		return DataCollections.users;
	}

	@Override
	public List<User> getAllStudentUser() {
		List<User> students = DataCollections.users.stream()
				 .filter(user->user.getRole().equals(Role.Student.name()))
				 .collect(Collectors.toList());
return students;
	}

	@Override
	public void saveUser(String username, String password, int isApproved, Role role) {
		User user = new User();
		user.setUserId(UUID.randomUUID());
		user.setUserName(username);
		user.setPassword(password);
		user.setCreateDate(new Date());
		user.setIsApprove(isApproved);
		user.setRole(role.name());
		user.setSession(false);
		DataCollections.users.add(user);
	}

}
