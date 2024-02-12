package com.ussd.ussd.repository;


import com.ussd.ussd.model.Ussd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UssdRepository extends JpaRepository<Ussd,Long> {
}
