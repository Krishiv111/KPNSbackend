package com.nighthawk.spring_portfolio.mvc.cancer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancerJpaRepository extends JpaRepository<Cancer, Long> {
    List<Cancer> findByDeathRate(double deathRate);

    List<Cancer> findByNumOfPeopleAffected(int numOfPeopleAffected);

    List<Cancer> findByAverageRecoveryTime(int averageRecoveryTime);

    List<Cancer> findBySymptoms(String symptoms);

    // You can add more custom query methods as needed for your application.
}
