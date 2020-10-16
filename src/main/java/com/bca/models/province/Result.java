package com.bca.models.province;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Robby Dianputra on 2/12/2018.
 */

public class Result {
    @JsonProperty("province_id")
    private String provinceId;

    private String province;

    public Result() {

    }

    public Result(String provinceId, String province) {
        this.provinceId = provinceId;
        this.province = province;
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

    @Override
    public String toString() {
        return "Result [province=" + province + ", provinceId=" + provinceId + "]";
    }

}
