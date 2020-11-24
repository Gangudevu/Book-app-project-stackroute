package com.stackroute.recommendationservice.service;

import java.util.List;

import com.stackroute.recommendationservice.model.Recommend;
import com.stackroute.recommendationservice.model.RecommendCount;

public interface RecommendService {
	public Recommend saveRecommendation(Recommend b);

	public Recommend getRecommendationById(String recId);

	public List<Recommend> getAll();

	void delete(String recId);

	public List<RecommendCount> getBookCount();

	public List<Recommend> getByBookId(String bookId);
	
	public List<Recommend> getByEmailId(String emailId);
}