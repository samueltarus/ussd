package com.ussd.ussd.service;

import com.ussd.ussd.model.UssdSession;
import com.ussd.ussd.repository.UssdSessionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UssdSessionServiceImpl implements UssdSessionService{

    private final UssdSessionRepository ussdSessionRepository;
    @Autowired
    public UssdSessionServiceImpl(UssdSessionRepository ussdSessionRepository) {
        this.ussdSessionRepository = ussdSessionRepository;
    }

    public List<UssdSession> sessions() {
        return  ussdSessionRepository.findAll();

    }
    public UssdSession findByMsisdn(String msisdn) {
        System.out.printf("msisdn " +msisdn);
        return ussdSessionRepository.findByMsisdn(msisdn);
    }
    public UssdSession findBySessionId(String sessionId) {
        System.out.println("sessionId " +sessionId);
        return ussdSessionRepository.findBySessionId(sessionId);
    }
    @Override
    public void save(UssdSession ussdSession1) {
        ussdSessionRepository.save(ussdSession1);
    }


}
