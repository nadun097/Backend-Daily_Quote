package com.example.Daily.Quotes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "quotes")
public class Quote {
    @Id
    private String id;
    private String userId;
    private String username;
    private String content;
    private LocalDateTime createdAt;
}

