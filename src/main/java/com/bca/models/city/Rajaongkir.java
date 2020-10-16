package com.bca.models.city;

/**
 * Created by Robby Dianputra on 2/13/2018.
 */

import java.util.List;

public class Rajaongkir {

    private List<Object> query = null;

    private Status status;

    private List<Result> results = null;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Object> getQuery() {
        return query;
    }

    public void setQuery(List<Object> query) {
        this.query = query;
    }

}
