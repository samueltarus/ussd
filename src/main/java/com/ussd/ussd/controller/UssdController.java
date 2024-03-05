package com.ussd.ussd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ussd.ussd.model.Language;
import com.ussd.ussd.model.Ussd;
import com.ussd.ussd.dto.UssdRequestDto;
import com.ussd.ussd.model.UssdSession;
import com.ussd.ussd.service.LanguageService;
import com.ussd.ussd.service.UssdService;
import com.ussd.ussd.service.UssdSessionService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

@RestController()
@RequestMapping("/api/v1")
public class UssdController {

    private String sessionId;

    private String input;

    private String inputValue;

    private String ussdSession;

    private String ussdUser;

    private String phoneNumber;

    private String registrationPhoneNumber;

    private String sessionAlert;

    private String backInput = "0";

    private String exitInput = "99";

    private String flag = "";

    private String vendor;

    @Autowired
    private UssdSessionService ussdSessionService;

    @Autowired
    private UssdService ussdService;

    @Autowired
    private LanguageService languageService;


    private void init(UssdRequestDto ussdRequest) {
        if (ussdRequest.getFormat().equals("at")) {
            phoneNumber = ussdRequest.getMsisdn();
            sessionId = ussdRequest.getSessionId();
            input = ussdRequest.getInput();

            String[] inputArr = input.split("\\*");

            if (inputArr.length > 0) {
                inputValue = inputArr[inputArr.length - 1].trim();
            }
        } else if (ussdRequest.getFormat().equals("cm")) {
            phoneNumber = ussdRequest.getMsisdn();
            sessionId = ussdRequest.getSessionId();
            input = ussdRequest.getInput();
            vendor = "airtel";
        }
        // TruRoute
        else {
            phoneNumber = ussdRequest.getMsisdn();
            sessionId = ussdRequest.getSessionId();
            input = ussdRequest.getInput();
            vendor = "tnm";
        }
        String[] inputArr = input.split("\\*");

        if (inputArr.length > 0) {
            inputValue = inputArr[inputArr.length - 1].trim();
        }
    }

    @GetMapping(value = "/ussd")
    public String handle(@RequestBody UssdRequestDto ussdRequest) {
        init(ussdRequest);
        //get session
        System.out.println("Get Sessions");
        UssdSession session   = ussdSessionService.findByMsisdn(phoneNumber);
        System.out.println("user sesisons");

        if (session==null) {
            //create new session
            UssdSession session1 =new UssdSession();
            System.out.println("session is null");
            System.out.println("ussdRequest.getSessionId() = " + ussdRequest.getSessionId());
            session1.setSessionId(ussdRequest.getSessionId());
            session1.setLanguage("ENG");
            System.out.println("ENG");
            session1.setUssdStep("LANG");
            session1.setMsisdn(ussdRequest.getMsisdn());
            session=session1;
            ussdSessionService.save(session1);
        } else {
            // if it's a new session reset ussd flow
            System.out.println("session existings");
            System.out.println("session = session");
            if (session.getSessionId().equals(sessionId)) {
                System.out.println("existing sessions sessionId" + sessionId);
                UssdSession ussdSession = ussdSessionService.findBySessionId(sessionId);
                System.out.println("ussdSession  ussdSession = ");
                session.setSessionId(ussdSession.getSessionId());
                session.setUssdStep(ussdSession.getUssdStep());
                session.setActionId(ussdSession.getActionId());
                session.setAccountAction(ussdSession.getAccountAction());
                session.setAccountId(ussdSession.getAccountId());
                session.setIdtype(ussdSession.getIdtype());
                session.setResponses(ussdSession.getResponses());
                session.setMsisdn(ussdSession.getMsisdn());
//                update session
                System.out.println("ussdSession1 = " + session);
                ussdSessionService.save(session);
                System.out.println("ussdSession1 = " + session);
            } else {
                session.setSessionId(sessionId);
                session.setUssdStep("LANG");
                session.setAccountAction("");
                session.setAccountId("");
                session.setActionId("");
                session.setIdtype("");
                session.setResponses("");
                session.setMsisdn(ussdRequest.getMsisdn());
                ussdSessionService.save(session);
            }
            //update the session
            session.setSessionId(sessionId);
            ussdSessionService.save(session);
        }
        // get current step
        String name = session.getUssdStep();
        System.out.println("ussdStep = " + name);
        // get menu
        Ussd ussd = ussdService.findByName(name);
        System.out.println("getName = " + ussd.getName());
        System.out.println("getNext = " + ussd.getNext());
        boolean valid = false;
        System.out.println("valid = " + valid);
        if (input != null && (!input.equals(backInput)) && (!input.equals(exitInput))) {
            String validation = "";
            System.out.println("validation = " + validation);
            if (ussd != null && ussd.getValidation() != null) {
                validation = ussd.getValidation();

            }
            System.out.println("validation = " + validation);
            if (validation.startsWith("regex")) {
                String regex = validation.replace("regex:", "");
                valid = Pattern.matches(regex, ussdRequest.getInput());
            }
            if (ussd.getName().matches("LANG")) {
                List<Language> languages = languageService.list();
                System.out.println("languages ");
                System.out.println("languages " + languages);
                int wardCount = languages.size();
                int inputValueAsInt = Integer.parseInt(inputValue.trim());
                valid =inputValueAsInt >= 1 && inputValueAsInt <= wardCount;
            }
            if (ussd.getName().matches("^MEMBER_SELECT_ACCOUNT_")) {
                ObjectMapper objectMapper = new ObjectMapper();
                String responsesJson = session.getResponses();
                String responses;

//                List<String> accounts = responses.getAccounts();
//                int count = accounts.size();
                int inputValueAsInt = Integer.parseInt(inputValue.trim());

//                valid= inputValueAsInt >= 1 && inputValueAsInt <= count;
            }
            System.out.println("valid = " + valid);

        }
        return "\n Welcome to Systech Individual  Pension Plan \n Are you a Member \n 1. Yes \n 2. No";
    }


}
