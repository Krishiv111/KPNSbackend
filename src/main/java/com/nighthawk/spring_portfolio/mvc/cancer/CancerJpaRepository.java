package com.nighthawk.spring_portfolio.mvc.cancer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancerJpaRepository extends JpaRepository<Cancer, Long> {
      // Custom query method to find by cancer type ignoring case

    List<Cancer> findByDeathRate(double deathRate);

    List<Cancer> findByNumOfPeopleAffected(int numOfPeopleAffected);

    List<Cancer> findByAverageRecoveryTime(int averageRecoveryTime);

    List<Cancer> findBySymptoms(String symptoms);

    List<Cancer> findByCancerTypeIgnoreCase(String cancerType);

    // You can add more custom query methods as needed for your application.
}