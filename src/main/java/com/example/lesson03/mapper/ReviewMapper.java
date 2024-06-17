package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input: id(int)
	// output : Review(단건) or null
	public Review selectReviewById(int id);
	
	// 2-1
	public int insertReview(Review review);
	
	// 2-2 @Param을 붙였으므로 하나의 맵으로 xml에 전송
	public int insertReviewAsField(
			@Param("storeId") int storeId111, 
			@Param("menu") String menu13423, 
			@Param("userName") String userName123456, 
			@Param("point") Double point345, 
			@Param("review") String review32112);
	
	public int updateReivewById(
			@Param("id") int id, 
			@Param("review") String review);
	
}
