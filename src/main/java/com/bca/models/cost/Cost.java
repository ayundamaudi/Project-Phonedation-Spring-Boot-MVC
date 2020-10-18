package com.bca.models.cost;

/**
 * Created by Robby Dianputra on 2/14/2018.
 */

import java.util.List;

public class Cost {

    private String service;

    private String description;

    private List<Cost_> cost = null;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Cost_> getCost() {
        return cost;
    }

    public void setCost(List<Cost_> cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Cost [cost=" + cost + ", description=" + description + ", service=" + service + "]";
    }

}
