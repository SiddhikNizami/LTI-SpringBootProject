package com.lt.crs.client;


import com.crs.lt.beans.User;
import com.crs.lt.constants.InputConstants;
import com.crs.lt.constants.Menu;
import com.crs.lt.service.ProfessorServiceInterface;
import com.crs.lt.service.UserServiceInterface;
import com.crs.lt.serviceimpl.ProfessorService;
import com.crs.lt.serviceimpl.UserService;
import com.crs.lt.util.Utils;

/**
 * @author user215
 * This is the professor menu
 *
 */
public class CrsProfessorMenu {

	private UserServiceInterface userService = new UserService();
	private ProfessorServiceInterface professorService = new ProfessorService();
	
	/*
	 * Professor Menu
	 * @params userObj
	 */
	public void createMenu(User userObj) {
		boolean isExit = false;
		while(!isExit) {
			Utils.printStatement(String.format(Menu.ProfessorMenu,Menu.LogOut));
			InputConstants.optionNumber = InputConstants.sc.nextInt();
			switch (InputConstants.optionNumber) {
			case 1:
//				professorService.addGrades();
				break;
			case 2:
				professorService.viewEnrolledStudents(userObj);
				break;
			case 3:
				professorService.viewCourse(userObj);
				break;
			case 4:
				userObj = userService.userLogout(userObj);
				isExit = true;
				break;
			default:
				break;
			}
		}


	}
}
