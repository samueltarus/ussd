package com.ussd.ussd.repository;

import com.ussd.ussd.model.UssdSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UssdSessionRepository extends JpaRepository<UssdSession, Long> {

    UssdSession findByMsisdn(String phoneNumber);
    UssdSession findBySessionId(String sessionId);
}
