package com.ussd.ussd.repository;


import com.ussd.ussd.model.Ussd;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UssdRepository extends JpaRepository<Ussd,Long> {
    Optional<Ussd> findByName(String name);
}
