package org.drools.runner.core.api;

public interface RulesRunner {

    public <Response> Response execute( Request request, String processId, Class<Response> responseClazz,
            String lookup );

    public <Response> Response execute( Request request, String processId, String lookup );

}