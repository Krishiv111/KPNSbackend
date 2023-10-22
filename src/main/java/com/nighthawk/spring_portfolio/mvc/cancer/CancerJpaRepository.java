package com.nighthawk.spring_portfolio.mvc.cancer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancerJpaRepository extends JpaRepository<Cancer, Long> {
    List<Cancer> findByDeaths(int deaths);

    List<Cancer> findByNumOfPeopleAffected(int numOfPeopleAffected);

    List<Cancer> findByAverageRecoveryTime(int averageRecoveryTime);

    List<Cancer> findBySymptoms(String symptoms);

    // Custom query method to find by cancer type ignoring case
    List<Cancer> findByCancerTypeIgnoreCase(String cancerType);

    // You can add more custom query methods as needed for your application.
}