package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper;
	
	// input: id(int)
	// output: Review(단건) or null
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);	
	}
	
	// input: Review
	// output: 성공한 행의 개수(int)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// 2-2
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// input: id, review
	// output: 성공한 행 개수
	public int updateReivewById(int id, String review) {
		return reviewMapper.updateReivewById(id, review);
	}
	
	// input: id
	// output: X
	public void deleteReviewById(int id) {
		reviewMapper.deleteReviewById(id);
	}
}






