package com.nighthawk.spring_portfolio.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.nighthawk.spring_portfolio.mvc.jokes.JokesJpaRepository;
import com.nighthawk.spring_portfolio.mvc.note.NoteJpaRepository;
import com.nighthawk.spring_portfolio.mvc.person.PersonDetailsService;
import com.nighthawk.spring_portfolio.mvc.quotes.Quotes;
import com.nighthawk.spring_portfolio.mvc.quotes.QuotesJpaRepository;
import com.nighthawk.spring_portfolio.mvc.cancer.Cancer;
import com.nighthawk.spring_portfolio.mvc.cancer.CancerJpaRepository;
import com.nighthawk.spring_portfolio.mvc.memorial.Memorial;
import com.nighthawk.spring_portfolio.mvc.memorial.MemorialJpaRepository;
import java.util.Optional;


import java.util.List;

@Component
@Configuration
public class ModelInit {
    @Autowired
    JokesJpaRepository jokesRepo;
    @Autowired
    NoteJpaRepository noteRepo;
    @Autowired
    PersonDetailsService personService;
    @Autowired
    CancerJpaRepository cancerRepo;
    @Autowired
    MemorialJpaRepository memorialRepo; // Assuming you have a MemorialJpaRepository

    @Bean
    CommandLineRunner init() {
        return args -> {
            // Joke database is populated with starting jokes (as you did before)

            // Person database is populated with test data (as you did before)

            // Initialize the cancer database with "get" methods for each attribute
            Cancer[] cancersArray = Cancer.init();
            for (Cancer cancer : cancersArray) {
                List<Cancer> cancerFound = cancerRepo.findByCancerTypeIgnoreCase(cancer.getCancerType());
                if (cancerFound.isEmpty()) {
                    Cancer newCancer = new Cancer();
                    newCancer.setCancerType(cancer.getCancerType());
                    newCancer.setNumOfPeopleAffected(cancer.getNumOfPeopleAffected());
                    newCancer.setDeathRate(cancer.getDeathRate());
                    newCancer.setAverageRecoveryTime(cancer.getAverageRecoveryTime());
                    newCancer.setSymptoms(cancer.getSymptoms());
                    cancerRepo.save(newCancer);
                }
            }

            // Initialize the memorial database with "get" methods for each attribute
            Memorial[] memorialsArray = Memorial.init();
            for (Memorial memorial : memorialsArray) {
                List<Memorial> memorialFound = memorialRepo.findByCancerTypeIgnoreCase(memorial.getCancerType());
                if (memorialFound.isEmpty()) {
                    Memorial newMemorial = new Memorial();
                    newMemorial.setName(memorial.getName());
                    newMemorial.setAge(memorial.getAge());
                    newMemorial.setCancerType(memorial.getCancerType());
                    newMemorial.setFavoriteMemory(memorial.getFavoriteMemory());
                    newMemorial.setTreatmentType(memorial.getTreatmentType());
                    memorialRepo.save(newMemorial);
                }
            }
        };
    }

    @Autowired
    QuotesJpaRepository quotesRepo; // Assuming you have a QuotesJpaRepository

    @Bean
    CommandLineRunner initQuotes() {
        return args -> {
            // Initialize the quotes database with some quotes
            String[] quotesArray = Quotes.init();
            for (String quote : quotesArray) {
                Optional<Quotes> existingQuote = quotesRepo.findByQuote(quote);
                if (!existingQuote.isPresent()) {
                    Quotes newQuote = new Quotes();
                    newQuote.setQuote(quote);
                    quotesRepo.save(newQuote);
                }
            }
        };
    }
}
