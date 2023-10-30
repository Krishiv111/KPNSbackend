package com.nighthawk.spring_portfolio.mvc.quotes;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotesJpaRepository extends JpaRepository<Quotes, Long> {
    Optional<Quotes> findById(int id);
    Optional<Quotes> findByQuote(String quote);

    // You don't need to define a custom save method, as JpaRepository provides it.
    // You can also remove the other custom methods that are not needed.

    // Additional custom methods can be added as needed.
    List<Quotes> findAllByOrderByQuoteAsc();
    List<Quotes> findByQuoteIgnoreCase(String quote);
}
