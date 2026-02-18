package com.example.Daily.Quotes.controller;
import com.example.Daily.Quotes.model.Quote;
import com.example.Daily.Quotes.model.QuoteRequest;
import com.example.Daily.Quotes.service.QuoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteService quoteService;
    @PostMapping
    public ResponseEntity<Quote> createQuote(
            @Valid @RequestBody QuoteRequest request,
            @AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();
        String username = jwt.getClaimAsString("preferred_username");
        if (username == null || username.isEmpty()) {
            username = jwt.getClaimAsString("email");
        }
        Quote savedQuote = quoteService.createQuote(userId, username, request.getContent());
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes() {
        List<Quote> quotes = quoteService.getAllQuotes();
        return ResponseEntity.ok(quotes);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Quote>> getQuotesByUserId(@PathVariable String userId) {
        List<Quote> quotes = quoteService.getQuotesByUserId(userId);
        return ResponseEntity.ok(quotes);
    }
}
