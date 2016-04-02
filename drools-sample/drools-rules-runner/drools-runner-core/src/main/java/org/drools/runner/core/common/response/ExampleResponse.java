package org.drools.runner.core.common.response;

import java.util.Collection;

import org.drools.runner.core.common.KieQuery;

public class ExampleResponse {

    @KieQuery(binding = "$fallout", queryName = "getAllFalloutMessages")
    private Collection<String> fallout;

    public ExampleResponse() {

    }

    public Collection<String> getFallout() {
        return fallout;
    }

    public void setFallout( Collection<String> fallout ) {
        this.fallout = fallout;
    }

}