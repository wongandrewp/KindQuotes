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
        ArrayList<Quote> quotes = new ArrayList<>();
        quoteRepository.findAll().forEach(quotes::add);
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Quote> getQuoteById(@PathVariable long id){
        Quote quote = quoteRepository.findOne(id);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote){
        quoteRepository.save(quote);
        return new ResponseEntity<>(quote, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Quote> deleteQuote(@PathVariable("id") long id){
        Quote quote = quoteRepository.findOne(id);
        quoteRepository.delete(id);
        return new ResponseEntity<Quote>(quote, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Quote> updateQuote(@PathVariable("id") long id, @RequestBody Quote quote){
//        quoteRepository.findOne(id).setMessage(quote.getMessage());
        quoteRepository.delete(id);
        quoteRepository.save(quote);
        return new ResponseEntity<Quote>(quote, HttpStatus.OK);
    }

}
