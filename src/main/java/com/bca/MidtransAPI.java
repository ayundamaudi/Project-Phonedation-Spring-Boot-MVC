package com.bca;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MidtransAPI {
  private static String API_URL = "https://app.sandbox.midtrans.com/snap/v1/transactions";
  private static String AUTH_STRING = "U0ItTWlkLXNlcnZlci1ZblNsOTk1dy12SHdVSlZXc21YeGczZDA6";
  private static HttpHeaders headers = new HttpHeaders();
  private static HttpEntity<Map<String, Object>> httpEntity;
  private static RestTemplate restTemplate = new RestTemplate();

  private static void init() {
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set("Authorization", "Basic " + AUTH_STRING);
  }

  public static ResponseEntity<String> snap(String orderId, int amount) {
    init();
    Map<String, Object> params = new HashMap<>();

    Map<String, String> transactionDetails = new HashMap<>();
    transactionDetails.put("order_id", String.valueOf(orderId));
    transactionDetails.put("gross_amount", String.valueOf(amount));

    params.put("transaction_details", transactionDetails);

    httpEntity = new HttpEntity<>(params, headers);
    return restTemplate.exchange(API_URL, HttpMethod.POST, httpEntity, String.class);
  }
}
