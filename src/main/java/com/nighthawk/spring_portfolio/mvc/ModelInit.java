package com.nighthawk.spring_portfolio.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.nighthawk.spring_portfolio.mvc.jokes.JokesJpaRepository;
import com.nighthawk.spring_portfolio.mvc.note.NoteJpaRepository;
import com.nighthawk.spring_portfolio.mvc.person.PersonDetailsService;
import com.nighthawk.spring_portfolio.mvc.cancer.Cancer;
import com.nighthawk.spring_portfolio.mvc.cancer.CancerJpaRepository;

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

    @Bean
    CommandLineRunner run() {
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
                    newCancer.setDeaths(cancer.getDeaths());
                    newCancer.setAverageRecoveryTime(cancer.getAverageRecoveryTime());
                    newCancer.setSymptoms(cancer.getSymptoms());
                    cancerRepo.save(newCancer);
                }
            }
        };
    }
}