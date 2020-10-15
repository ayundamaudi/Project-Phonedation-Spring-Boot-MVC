package com.bca;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.bca.models.MidtransRequest;
import com.bca.models.MidtransResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

  public static ResponseEntity<String> snap(int orderId, int amount) {
    init();
    Map<String, Object> params = new HashMap<>();

    Map<String, String> transactionDetails = new HashMap<>();
    transactionDetails.put("order_id", String.valueOf(orderId));
    transactionDetails.put("gross_amount", String.valueOf(amount));

    params.put("transaction_details", transactionDetails);

    // MidtransRequest body = new MidtransRequest(124999);
    // String body = "{ 'transaction_details': {'order_id': '" + orderId + "',
    // 'gross_amount': " + amount + " }}";
    httpEntity = new HttpEntity<>(params, headers);
    return restTemplate.exchange(API_URL, HttpMethod.POST, httpEntity, String.class);
  }
}
