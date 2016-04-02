package org.drools.runner.core.api;

import java.util.Collection;

/**
 * A minimal request interface to execute rules via Stateless Service. Allows Globals and possibly other session
 * configurations to be invoked on a service.
 *
 */
public interface Request {

    public Collection<Object> getFacts();

}
