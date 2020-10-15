package com.bca.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MidtransResponse {
  private String token;

  @JsonProperty("redirect_url")
  private String redirectUrl;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  @Override
  public String toString() {
    return "MidtransResponse [redirectUrl=" + redirectUrl + ", token=" + token + "]";
  }
}
