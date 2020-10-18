package com.bca.models.cost;

/**
 * Created by Robby Dianputra on 2/14/2018.
 */

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rajaongkir {

    private Query query;

    private Status status;

    @JsonProperty("origin_details")
    private OriginDetails originDetails;

    @JsonProperty("destination_details")
    private DestinationDetails destinationDetails;

    private List<Result> results = null;

    @Override
    public String toString() {
        return "Rajaongkir [destinationDetails=" + destinationDetails + ", originDetails=" + originDetails + ", query="
                + query + ", results=" + results + ", status=" + status + "]";
    }

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

    public OriginDetails getOriginDetails() {
        return originDetails;
    }

    public void setOriginDetails(OriginDetails originDetails) {
        this.originDetails = originDetails;
    }

    public DestinationDetails getDestinationDetails() {
        return destinationDetails;
    }

    public void setDestinationDetails(DestinationDetails destinationDetails) {
        this.destinationDetails = destinationDetails;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
