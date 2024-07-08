package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	// Spring Data JPA vs 순수 JPA
	// 하기 4개는 jpa에 포함되어있는것이라 별도로 만들필요없음
	// public StudentEntity save(StudentEntity student)
	// public StudetnEntity findById(int id)
	// public void delete(StudentEntity students)
	// public List<StudentEntity> findAll()
	
	// ex02/select1 - JPQL문법 메소드명을 만들면 규칙에 따라 자동으로 실행해줌
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name11111);
	public List<StudentEntity> findByNameIn(List<String> names11111);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String keyword);
	public List<StudentEntity> findByNameStartingWith(String keyword);
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	// ex02/select2 native query 내가직접쿼리문작성
	//@Query(value = "select * from `new_student` where `dreamJob` = :dreamJob", nativeQuery = true) // nativeQuery = true => DB에 직접 SQL 쿼리 수행
	
	// ex02/select2-1 => JPQL(Entity를 조회:쿼리는 back에서 알아서 해줌) - SQL query 아님!
	@Query(value = "select s from StudentEntity s where s.dreamJob = :dreamJob")  // nativeQuery = false
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);

}
