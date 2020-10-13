package com.bca.models.province;

/**
 * Created by Robby Dianputra on 2/12/2018.
 */

import java.util.List;

public class Rajaongkir {

    private List<Object> query = null;

    private Status status;

    private List<Result> results = null;

    public List<Object> getQuery() {
        return query;
    }

    public void setQuery(List<Object> query) {
        this.query = query;
    }

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

}
