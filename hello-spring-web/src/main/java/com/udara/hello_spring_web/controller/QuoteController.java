package com.udara.hello_spring_web.controller;

import com.udara.hello_spring_web.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1. Tells Spring this is a REST controller.
public class QuoteController {

    // 2. Declare the dependency on the service layer.
    private final QuoteService quoteService;

    // 3. Use Constructor Injection to get the service bean from Spring.
    // Spring sees this constructor and automatically passes in the single instance of QuoteService.
    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    // 4. Create a new endpoint to get a quote by its ID.
    // We use @PathVariable to get the ID from the URL path itself.
    // Example URL: http://localhost:8080/quotes/1
    @GetMapping("/quotes/{id}")
    public String getQuote(@PathVariable Integer id) {
        // 5. The controller delegates the work to the service.
        // It doesn't know or care how the quote is fetched.
        return quoteService.getQuoteById(id);
    }

}
