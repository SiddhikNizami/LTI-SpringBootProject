package com.crs.lt.serviceimpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import com.crs.lt.beans.Student;
import com.crs.lt.beans.User;
import com.crs.lt.constants.DataCollections;
import com.crs.lt.constants.InputConstants;
import com.crs.lt.constants.Role;
import com.crs.lt.dao.UserDao;
import com.crs.lt.daoimpl.UserDaoImpl;
import com.crs.lt.service.UserServiceInterface;
import com.crs.lt.util.Utils;

public class UserService implements UserServiceInterface{
	
	private UserDao userDao = new UserDaoImpl();
	private StudentService studentService = new StudentService();

	@Override
	public User userLogin() {
		boolean credentialCheck = true;
		User userObj = null;
		while(credentialCheck) {
			Utils.printStatement("Enter the emailId");
			String username = InputConstants.sc.next();
			Utils.printStatement("Enter Password");
			String password = InputConstants.sc.next();
			userObj = userDao.getUser(username);
			if(checkingCredentials(userObj,username,password)) {
//				userObj = UsersList.users.stream()
//						.filter(user->user.getUserName().equals(username))
//						.findFirst().get();
				credentialCheck = false;
			}
		}
		Utils.printStatement("User successfully logged in");
		userObj.setSession(true);
		return userObj;
	}

	@Override
	public void registerUser() {

		User user = new User();
		Utils.printStatement("Registeration form");
		boolean isUserExist = true;
		String username = "";
		while(isUserExist) {
			Utils.printStatement("Enter emailId");
			username = InputConstants.sc.next();
			if(!isUsernameExist(username))
				isUserExist = false;
			else
				Utils.printStatement("EmailId exist. Try with another emailId");
		}
		Utils.printStatement("Enter the password");
		String password = InputConstants.sc.next();
		user.setUserName(username);
		user.setPassword(password);
		createUser(user,0,Role.Student);
		userDao.saveUser(user);
		addStudent(user);
		Utils.printStatement("User Register successfully");
	}

	private void addStudent(User user) {
		Student student = new Student();
		student.setStudentId(user.getUserId());
		studentService.addStudent(student);
	}

	public void createUser(User user,int isApprove,Role role) {
		user.setUserId(UUID.randomUUID());
		user.setCreateDate(LocalDate.now());
		user.setIsApprove(isApprove);
		user.setRole(role.name());
		user.setSession(false);
		user.setEmailId(user.getUserName());
		System.out.println("Enter your first name");
		user.setFirstName(InputConstants.sc.next());
		System.out.println("Enter your last name");
		user.setLastName(InputConstants.sc.next());
		System.out.println("Enter date of birth (DD/MM/yyyy)");
		user.setDateOfBirth(InputConstants.sc.next());
		System.out.println("Enter address");
		user.setAddress(InputConstants.sc.next());
		System.out.println("Enter pin code");
		user.setPincode(InputConstants.sc.nextInt());
		System.out.println("Enter location");
		user.setLocation(InputConstants.sc.next());
		System.out.println("Enter country");
		user.setCountry(InputConstants.sc.next());
	}

	@Override
	public void resetPassword() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword() {
		System.out.println("Enter the emailId");
		InputConstants.input = InputConstants.sc.next();
		System.out.println("Enter old password");
		String oldPassword = InputConstants.sc.next();
		System.out.println("Enter new password");
		String newPassword = InputConstants.sc.next();
		
		User user = userDao.getUser(InputConstants.input);
		
		if(user!= null) {
			if(user.getPassword().equals(oldPassword)) {
				user.setPassword(newPassword);
				System.out.println("Password successfully changed");
			}
			else
				System.out.println("Password is incorrect");
		}else {
			System.out.println("User not found");
		}
		
		

	}

	private boolean checkingCredentials(User user,String username, String password) {
		if(user!=null) {
			if(user.getPassword().equals(password))
				return true;
			else {
				System.out.println("Password does not match");
				return false;
			}
		}else {
			System.out.println("User not found");
			return false;
		}
	}

	private boolean isUsernameExist(String username) {
		return DataCollections.users.stream().map(User :: getUserName)
				.anyMatch(existUsername -> existUsername.equals(username));
	}

	@Override
	public User userLogout(User user) {
		user.setSession(false);
		return user;
	}

}
