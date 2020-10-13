package com.bca;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

  public static ResponseEntity<com.bca.models.province.Rajaongkir> findAllProvince() {
    init();
    return restTemplate.exchange(API_URL.concat("/province"), HttpMethod.GET, httpEntity,
        com.bca.models.province.Rajaongkir.class);
  }

  public static ResponseEntity<com.bca.models.city.Rajaongkir> findAllCity() {
    init();
    return restTemplate.exchange(API_URL.concat("/city"), HttpMethod.GET, httpEntity,
        com.bca.models.city.Rajaongkir.class);
  }
}
