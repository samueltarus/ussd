package com.ussd.ussd.controller;

import com.ussd.ussd.model.Ussd;
import com.ussd.ussd.dto.UssdRequestDto;
import com.ussd.ussd.model.UssdSession;
import com.ussd.ussd.service.UssdService;
import com.ussd.ussd.service.UssdSessionService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


    private void init(UssdRequestDto ussdRequest) {
        if (ussdRequest.getFormat().equals("at")) {
            phoneNumber = ussdRequest.getMsisdn();
            sessionId = ussdRequest.getSessionId();
            input = ussdRequest.getInput();
        } else if (ussdRequest.getFormat() .equals("cm")) {
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
    }
    @GetMapping(value = "/ussd")
    public String handle(@RequestBody UssdRequestDto ussdRequest) {
        init(ussdRequest);

        //get session
        System.out.println("ussdRequest = " + ussdRequest);
        System.out.println("Get Sessions");
        UssdSession session = ussdSessionService.findByMsisdn(phoneNumber);
        System.out.println("user sesisons");
        if (session==null) {
            //create new session
            System.out.println("session is null");

            UssdSession ussdSession1 = new UssdSession();
            ussdSession1.setSessionId(sessionId);
            ussdSession1.setUssdStep("LANG");
            ussdSession1.setMsisdn(ussdRequest.getMsisdn());
            ussdSessionService.save(ussdSession1);
        } else {
            UssdSession ussdSession1 = new UssdSession();
            // if it's a new session reset ussd flow
            System.out.println("session existings");
            if (session.getSessionId().equals(sessionId)) {
                System.out.println("existing sessions sessionId" +sessionId);
                UssdSession ussdSession = ussdSessionService.findBySessionId(sessionId);
                ussdSession1.setSessionId(ussdSession.getSessionId());
                ussdSession1.setUssdStep(ussdSession.getUssdStep());
                ussdSession1.setActionId(ussdSession.getActionId());
                ussdSession1.setAccountAction(ussdSession.getAccountAction());
                ussdSession1.setAccountId(ussdSession.getAccountId());
                ussdSession1.setIdtype(ussdSession.getIdtype());
                ussdSession1.setResponses(ussdSession.getResponses());
                ussdSession1.setMsisdn(ussdSession.getMsisdn());
//                update session
                System.out.println("ussdSession1 = " + ussdSession1);
                ussdSessionService.save(ussdSession1);
                System.out.println("ussdSession1 = " + ussdSession1);
            }else {
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
            ussdSessionService.save(ussdSession1);

        }
        // get current step
        String ussdStep = session.getUssdStep();
        System.out.println("ussdStep = " + ussdStep);
        // get menu
        Ussd ussd = ussdService.list(ussdStep);
        boolean valid = false;

        if (ussdRequest.getInput() != null && (!ussdRequest.getInput().equals(backInput))
                && (!ussdRequest.getInput().equals(exitInput))) {

            var validation = ussd!=null && ussd.getValidation()!=null ? ussd.getValidation() : "";

            if (validation.startsWith("regex")) {
                String regex = validation.replace("regex:", "");
                 valid = Pattern.matches(regex, ussdRequest.getInput());
            }
            if (ussd != null && ussd.getName() != null && ussd.getName().startsWith("LANG")) {
                int wardCount =0;
                 valid = ((Integer.parseInt(ussdRequest.getInput()) >= 1)
                        && (Integer.parseInt(ussdRequest.getInput()) <= wardCount));
            }
        }

        return "welcome to systech ussd";
    }

}
