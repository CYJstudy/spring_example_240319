package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {

	@Autowired
	private StudentBO studentBO;
	
	// 학생 가입 화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// DB Insert => 방금 가입된 학생 select => 화면
		@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student,
			Model model) {
		
		// DB Insert
		studentBO.addStudent(student);
		
		// DB Select => 방금 가입된 학생
		int id = student.getId();
		Student latestStudent = studentBO.getStudentById(id);
		
		// Model에 데이터를 담는다.
		model.addAttribute("student", latestStudent);		
		
		// 화면 이동
		return "lesson04/afterAddStudent";
	}
}
