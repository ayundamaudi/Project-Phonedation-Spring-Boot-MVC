package com.bca.models.city;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Robby Dianputra on 2/13/2018.
 */

public class Result {

    @JsonProperty("city_id")
    private String cityId;

    @JsonProperty("province_id")
    private String provinceId;

    private String province;

    private String type;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("postal_code")
    private String postalCode;

    public Result() {

    }

    public Result(String cityId, String provinceId, String province, String type, String cityName, String postalCode) {
        this.cityId = cityId;
        this.provinceId = provinceId;
        this.province = province;
        this.type = type;
        this.cityName = cityName;
        this.postalCode = postalCode;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Result [cityId=" + cityId + ", cityName=" + cityName + ", postalCode=" + postalCode + ", province="
                + province + ", provinceId=" + provinceId + ", type=" + type + "]";
    }

}
