package com.example.Daily.Quotes.repository;

import com.example.Daily.Quotes.model.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends MongoRepository<Quote, String> {
    List<Quote> findByUserIdOrderByCreatedAtDesc(String userId);
    List<Quote> findAllByOrderByCreatedAtDesc();
}

