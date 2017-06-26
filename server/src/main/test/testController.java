import io.zipcoder.kindquotes.config.QuoteConfig;
import io.zipcoder.kindquotes.controller.QuoteController;
import io.zipcoder.kindquotes.model.Quote;
import io.zipcoder.kindquotes.repository.QuoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by andrewwong on 6/26/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QuoteConfig.class)
public class testController {

    @InjectMocks
    private QuoteController quoteController;

    @Mock
    private QuoteRepository quoteRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void contextLoads(){

    }

    @Test
    public void testGetAllQuotes(){
        String quoteOneString = "Great job!";
        String quoteTwoString = "Nice!";
        Quote quoteOne = new Quote(quoteOneString);
        Quote quoteTwo = new Quote(quoteTwoString);
        quoteOne.setId(1);
        quoteTwo.setId(2);
        List<Quote> quoteList = new ArrayList<>();
        quoteList.add(quoteOne);
        quoteList.add(quoteTwo);

        when(quoteRepository.findAll()).thenReturn(quoteList);
        List<Quote> actualList = quoteController.getAllQuotes().getBody();

        assertEquals("Expected quote one returned", quoteOneString, actualList.get(0).getMessage());
        assertEquals("Expected quote two returned", quoteTwoString, actualList.get(1).getMessage());
    }

}
