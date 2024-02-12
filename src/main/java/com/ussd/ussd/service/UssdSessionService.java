package com.ussd.ussd.service;


import com.ussd.ussd.model.UssdSession;
import java.util.List;

public interface UssdSessionService {

    List<UssdSession> sessions();
    UssdSession findByMsisdn(String msisdn);
    UssdSession findBySessionId(String sessionId);

    void save(UssdSession ussdSession1);
}
