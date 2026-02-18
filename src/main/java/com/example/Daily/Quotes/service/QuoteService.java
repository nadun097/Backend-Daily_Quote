package com.example.Daily.Quotes.service;

import com.example.Daily.Quotes.model.Quote;
import com.example.Daily.Quotes.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public Quote createQuote(String userId, String username, String content) {
        Quote quote = Quote.builder()
                .userId(userId)
                .username(username)
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();
        return quoteRepository.save(quote);
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Quote> getQuotesByUserId(String userId) {
        return quoteRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }
}

