package org.drools.runner.core.exception;

/**
 * A runtime exception representing something went wrong in the API.
 *
 */
public class KnowledgeRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public KnowledgeRuntimeException( String message ) {
        super( message );
    }

    public KnowledgeRuntimeException() {
        super();
    }

    public KnowledgeRuntimeException( String message, Throwable cause ) {
        super( message, cause );
    }

    public KnowledgeRuntimeException( Throwable cause ) {
        super( cause );
    }
}
