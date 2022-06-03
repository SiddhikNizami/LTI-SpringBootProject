package com.crs.lt.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.crs.lt.beans.Course;
import com.crs.lt.beans.Student;
import com.crs.lt.service.BillingServiceInterface;

public class BillingService implements BillingServiceInterface {

	private StudentService studentService = new StudentService();
	private CourseService courseService = new CourseService();
	
	@Override
	public double generateBill(UUID userId) {
		Student student = studentService.getStudentById(userId);
		double totalBill = 0;
		if(student.getCourse()!=null && !student.getCourse().isEmpty()) {
			List<Course> courses = courseService.getCoursesByCourseName(Arrays.asList(student.getCourse().split(",")));
			totalBill = courses.stream().mapToDouble(Course::getPrice).sum();
		}else {
			System.out.println("Please add the course.");
		}
		return totalBill;
	}
}
