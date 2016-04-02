package org.drools.runner.core.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used in request objects injected into the Knowledge session.
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface KieGlobal {

    /**
     * The identifier of the global.
     * 
     * @return
     */
    String globalIdentifier();

}
