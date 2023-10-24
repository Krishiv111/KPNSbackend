package com.nighthawk.spring_portfolio.mvc.memorial;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface MemorialJpaRepository extends JpaRepository<Memorial, Long> {
    List<Memorial> findByCancerTypeIgnoreCase(String cancerType);
    List<Memorial> findByAge(int age);
    List<Memorial> findByFavoriteMemory(String favoriteMemory);
    List<Memorial> findByTreatmentType(String treatmentType);

    
}