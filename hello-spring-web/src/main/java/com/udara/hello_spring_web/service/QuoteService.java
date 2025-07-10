package com.udara.hello_spring_web.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service // 1. This is a Spring bean in our service layer.
public class QuoteService {

    // A simple in-memory "database" to store quotes.
    // We use ConcurrentHashMap because it's thread-safe, which is important in web apps.
    private final Map<Integer, String> quotes = new ConcurrentHashMap<>();

    public QuoteService() {
        // Pre-populate with some data
        quotes.put(1, "The best way to predict the future is to invent it. - Alan Kay");
        quotes.put(2, "Walking on water and developing software from a specification are easy if both are frozen. - Edward V. Berard");
        quotes.put(3, "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. - Martin Fowler");
    }

    public String getQuoteById(int id) {
        return quotes.getOrDefault(id, "Quote not found. Try an ID from 1 to 3.");
    }
}
