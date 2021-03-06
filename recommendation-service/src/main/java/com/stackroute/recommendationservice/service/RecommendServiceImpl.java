package com.stackroute.recommendationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import com.stackroute.recommendationservice.model.Recommend;
import com.stackroute.recommendationservice.model.RecommendCount;
import com.stackroute.recommendationservice.repository.RecommendRepository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

@Service
public class RecommendServiceImpl implements RecommendService {
	@Autowired
	RecommendRepository rs;
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Recommend saveRecommendation(Recommend b) {
		Recommend r = rs.save(b);
		return r;
	}

	@Override
	public Recommend getRecommendationById(String recId) {
		Recommend o = rs.findByRecId(recId);
		if (o != null)
			return o;
		else
			return null;
	}

	@Override
	public List<Recommend> getAll() {
		return rs.findAll();
	}

	@Override
	public void delete(String recId) {
		rs.deleteByRecId(recId);
	}

	@Override
	public List<RecommendCount> getBookCount() {
		Aggregation agg = newAggregation(group("bookId").count().as("count"),
				project("count").and("bookId").previousOperation(), sort(Sort.Direction.DESC, "count"));
		// Convert the aggregation result into a List
		AggregationResults<RecommendCount> groupResults = mongoTemplate.aggregate(agg, Recommend.class,
				RecommendCount.class);
		return groupResults.getMappedResults();
	}

	@Override
	public List<Recommend> getByBookId(String bookId) {
		return rs.findByBookId(bookId);
	}

	@Override
	public List<Recommend> getByEmailId(String emailId) {
		
		return rs.findByEmail(emailId);
	}
	
}
