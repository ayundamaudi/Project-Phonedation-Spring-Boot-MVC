package com.bca.models.province;

/**
 * Created by Robby Dianputra on 2/12/2018.
 */

public class Result {

    private String provinceId;

    private String province;

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

}
