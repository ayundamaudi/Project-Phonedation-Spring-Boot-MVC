package com.bca;

import java.util.HashMap;
import java.util.Map;

import com.bca.models.RajaOngkirCityResponse;
import com.bca.models.RajaOngkirProvinceResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RajaOngkirAPI {

  private static String API_URL = "https://api.rajaongkir.com/starter";
  private static String API_KEY = "e65bf306954919dbd12be40b8a6e7669";
  private static HttpHeaders headers = new HttpHeaders();
  private static HttpEntity<String> httpEntity;
  private static RestTemplate restTemplate = new RestTemplate();

  private static void init() {
    headers.set("key", API_KEY);
    httpEntity = new HttpEntity<>("body", headers);
  }

  public static ResponseEntity<RajaOngkirProvinceResponse> findAllProvince() {
    init();
    return restTemplate.exchange(API_URL.concat("/province"), HttpMethod.GET, httpEntity,
        RajaOngkirProvinceResponse.class);
  }

  public static ResponseEntity<RajaOngkirCityResponse> findAllCity() {
    init();
    return restTemplate.exchange(API_URL.concat("/city"), HttpMethod.GET, httpEntity, RajaOngkirCityResponse.class);
  }

  public static ResponseEntity<String> cost(String origin, String destination, double weight, String courier) {
    init();
    Map<String, Object> params = new HashMap<>();

    Map<String, String> transactionDetails = new HashMap<>();
    transactionDetails.put("origin", String.valueOf(origin));
    transactionDetails.put("destination", String.valueOf(destination));
    transactionDetails.put("weight", String.valueOf(weight));
    transactionDetails.put("courier", String.valueOf(courier));

    params.put("transaction_details", transactionDetails);

    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Map<String, String>> ent = new HttpEntity<>(transactionDetails, headers);

    return restTemplate.exchange(API_URL.concat("/cost"), HttpMethod.POST, ent, String.class);
  }
}
