package com.bca.models.cost;

/**
 * Created by Robby Dianputra on 2/14/2018.
 */

import java.util.List;

public class Result {

    private String code;

    private String name;

    private List<Cost> costs = null;

    public Result() {

    }

    public Result(String code, String name, List<Cost> costs) {
        this.code = code;
        this.name = name;
        this.costs = costs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", costs=" + costs + ", name=" + name + "]";
    }

}
