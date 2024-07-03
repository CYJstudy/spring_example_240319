package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	// Spring Data JPA vs 순수 JPA
	// 하기 4개는 jpa에 포함되어있는것이라 별도로 만들필요없음
	// public StudentEntity save(StudentEntity student)
	// public StudetnEntity findById(int id)
	// public void delete(StudentEntity students)
	// public List<StudentEntity> findAll()
	
	// ex02/select1 - JPQL 문법
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name11111);
	public List<StudentEntity> findByNameIn(List<String> names11111);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String keyword);
	public List<StudentEntity> findByNameStartingWith(String keyword);
	public List<StudentEntity> findByIdBetween(int startId, int endId);

}
