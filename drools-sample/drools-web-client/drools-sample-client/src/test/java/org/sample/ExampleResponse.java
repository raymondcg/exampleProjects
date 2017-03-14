package org.sample;

import java.util.Collection;

import org.drools.runner.core.common.KieQuery;

public class ExampleResponse {

	@KieQuery(binding = "$fallout", queryName = "Get All Fallout Messages")
	private Collection<Fallout> fallout;

	public ExampleResponse() {

	}

	public Collection<Fallout> getFallout() {
		return fallout;
	}

	public void setFallout(Collection<Fallout> fallout) {
		this.fallout = fallout;
	}

}