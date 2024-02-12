package com.ussd.ussd.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UssdRequestDto{
   private String format;
   private String msisdn;
   private String sessionId;
   private String input;
}
