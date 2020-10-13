package com.bca.models.city;

/**
 * Created by Robby Dianputra on 2/13/2018.
 */

import java.util.List;

public class Rajaongkir {

    private Query query;

    private Status status;

    private List<Result> results = null;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
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
