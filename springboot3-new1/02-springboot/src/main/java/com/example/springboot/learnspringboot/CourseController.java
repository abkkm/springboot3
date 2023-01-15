package com.example.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
				new Course(1, "Learn AWS", "example"),
				new Course(2, "Learn DevOps", "example"),
				new Course(3, "Learn Azure", "example"),
				new Course(4, "Learn GCP", "example"),
				new Course(5, "Learn Terraform", "example")
				
				);
	}

}
