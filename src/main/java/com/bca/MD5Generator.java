package com.bca;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Generator {

  public static String encode(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    byte[] bytesOfMessage = data.getBytes("UTF-8");

    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] thedigest = md.digest(bytesOfMessage);
    BigInteger num = new BigInteger(1, thedigest);
    String hash = num.toString(16);
    while (hash.length() < 20) {
      hash = "0" + hash;
    }
    return hash;
  }
}
