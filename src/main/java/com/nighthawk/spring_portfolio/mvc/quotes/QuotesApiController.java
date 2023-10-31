package com.nighthawk.spring_portfolio.mvc.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quotes")
public class QuotesApiController {

    @Autowired
    private QuotesJpaRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Quotes>> getQuotes() {
        // ResponseEntity returns List of Quotes provided by JPA findAll()
        List<Quotes> quotes = repository.findAll();
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quotes> getQuoteById(@PathVariable Long id) {
        Optional<Quotes> optional = repository.findById(id);
        return optional.map(quotes -> new ResponseEntity<>(quotes, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/random")
    public ResponseEntity<Quotes> getRandomQuote() {
        List<Quotes> allQuotes = repository.findAll();
        if (allQuotes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Generate a random index to select a random quote
        int randomIndex = (int) (Math.random() * allQuotes.size());
        Quotes randomQuote = allQuotes.get(randomIndex);

        return new ResponseEntity<>(randomQuote, HttpStatus.OK);
    }
}
