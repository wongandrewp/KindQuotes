package io.zipcoder.kindquotes.controller;

import io.zipcoder.kindquotes.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/quotes")
@RestController
@CrossOrigin("http://localhost:8100")
public class QuoteController {

    @RequestMapping("/")
    public ResponseEntity<ArrayList<Quote>> getAllQuotes(){
        Quote quote = new Quote("Wu Tang Clan!!!");
        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quote);
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

}
