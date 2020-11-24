package com.stackroute.recommendationservice.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.recommendationservice.model.Recommend;

public interface RecommendRepository extends MongoRepository<Recommend, String> {
	public List<Recommend> findByEmail(String email);

	public Recommend findByRecId(String recId);

	public void deleteByRecId(String recId);

	// count
	public long countByBookId(String bookId);

	public List<Recommend> findByBookId(String bookId);
	
}
