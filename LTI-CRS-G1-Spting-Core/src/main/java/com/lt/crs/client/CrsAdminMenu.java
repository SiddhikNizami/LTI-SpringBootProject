package com.lt.crs.client;

import com.crs.lt.beans.User;
import com.crs.lt.constants.InputConstants;
import com.crs.lt.constants.Menu;
import com.crs.lt.service.AdminServiceInterface;
import com.crs.lt.service.CourseServiceInterface;
import com.crs.lt.service.ProfessorServiceInterface;
import com.crs.lt.service.UserServiceInterface;
import com.crs.lt.serviceimpl.AdminService;
import com.crs.lt.serviceimpl.CourseService;
import com.crs.lt.serviceimpl.ProfessorService;
import com.crs.lt.serviceimpl.UserService;
import com.crs.lt.util.Utils;

/**
 * @author user215
 * This is the admin menu
 *
 */
public class CrsAdminMenu {

	private AdminServiceInterface adminService = new AdminService();
	private UserServiceInterface userService = new UserService();
	private CourseServiceInterface courseService = new CourseService();
	private ProfessorServiceInterface professorService = new ProfessorService();
	
	/*
	 * @author user215
	 * Admin menu
	 * @params userObj
	 */
	public void createMenu(User userObj) {
		boolean isExit = false;
		while(!isExit) {
			Utils.printStatement(String.format(Menu.AdminMenu,Menu.LogOut));
			InputConstants.optionNumber = InputConstants.sc.nextInt();
			switch (InputConstants.optionNumber) {
			case 1:
				courseService.addCourse();
				break;
			case 2:
				courseService.removeCourse();
				break;
			case 3: 
				professorService.addProfessor();
				break;
			case 4:
				adminService.approveStudents();
				break;
			case 5:
				//generate report card
				System.out.println("work in progress");
				break;
			case 6:
				userObj = userService.userLogout(userObj);
				isExit = true;
				break;
			default:
				break;
			}
		}


	}
}
