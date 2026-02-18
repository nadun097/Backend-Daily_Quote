package com.example.Daily.Quotes.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteRequest {
    @NotBlank(message = "Content cannot be empty")
    @Size(max = 300, message = "Content cannot exceed 300 characters")
    private String content;
}

