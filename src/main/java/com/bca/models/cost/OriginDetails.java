package com.bca.models.cost;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Robby Dianputra on 2/14/2018.
 */

public class OriginDetails {

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

}
