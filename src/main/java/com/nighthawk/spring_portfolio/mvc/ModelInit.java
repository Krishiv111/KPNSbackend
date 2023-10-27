package com.nighthawk.spring_portfolio.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.nighthawk.spring_portfolio.mvc.jokes.JokesJpaRepository;
import com.nighthawk.spring_portfolio.mvc.memorial.Memorial;
import com.nighthawk.spring_portfolio.mvc.memorial.MemorialJpaRepository;
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
    @Autowired
    MemorialJpaRepository memorialRepo; // Inject the MemorialJpaRepository bean

    @Bean
    CommandLineRunner run() {
        return args -> {
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
        };
    }
}
