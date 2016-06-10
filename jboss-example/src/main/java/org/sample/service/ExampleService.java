package org.sample.service;

import javax.ws.rs.core.Response;

public interface ExampleService {
	
	// Kinda bad to be using an implementation specific class in the interface....
	public Response isRunning();
	
}