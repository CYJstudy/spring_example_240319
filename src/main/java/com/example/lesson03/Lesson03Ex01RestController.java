package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex01?id=7
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터
			//@RequestParam(value = "id") int id // 필수 파라미터 (required 생략, 기본값은 true)
			//@RequestParam(value = "id", required = true) int id // 필수 파라미터, null 값이 들어가지 않는다고 생각하고 int로 선언
			//@RequestParam(value = "id", required = false) Integer id // 비필수 파라미터, null값이 들어갈수도있으므로 Integer로 선언
			//@RequestParam(value = "id", defaultValue = "1") int id // 비필수 파라미터 + 기본값 1
			) {
		
//		if(id == null) {
//			id = 1;
//		}
		return reviewBO.getReviewById(id); // response JSON String
	}
}
