package io.zipcoder.kindquotes.controller;

import io.zipcoder.kindquotes.model.Quote;
import io.zipcoder.kindquotes.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/quotes")
@RestController
@CrossOrigin("http://localhost:8100")
public class QuoteController {

    @Autowired
    private QuoteRepository quoteRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Quote>> getAllQuotes(){
        Quote quote = new Quote("Wu Tang Clan!!!");
        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quote);
        quoteRepository.findAll().forEach(quotes::add);
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote){
        quoteRepository.save(quote);
        return new ResponseEntity<>(quote, HttpStatus.CREATED);
    }

}
