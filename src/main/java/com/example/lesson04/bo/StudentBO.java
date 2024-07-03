package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// create
	// input: 파라미터 4개(name, phoneNumber, email, dreamJob)
	// output: StudentEntity(단건)
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now())  // @CreationTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// update
	// input: id, dreamJob
	// output: StudentEntity or null
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터 조회 => StudentEntity 가져온다
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// Entity에 데이터 값을 update하고싶은 값으로 변경해놓는다
		if (student != null) {
			student = student.toBuilder() // 꼭 객체에 다시 저장!, toBuilder는 일부 지정한값만 변경하고 다른 값들은 기존대로 유지 됨
					.dreamJob(dreamJob)
					.build(); 		
			
			// update
			// save 요청
			student = studentRepository.save(student);
		}
		
		return student;
	}
	
	// delete
	// input: id
	// output: X
	public void deleteStudentById(int id) {
		// 방법1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법2)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
	
	
	// input: Student
	// output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// input: id
	// output: Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
}
