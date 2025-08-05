package com.portfolio.portfolio_backend.Repository;

import com.portfolio.portfolio_backend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
