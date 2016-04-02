package org.drools.runner.core.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Utilized by response class objects to pull data from the Drools Knowledge Session.
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface KieQuery {

    /**
     * The name of the Query
     * 
     * @return
     */
    String queryName();

    /**
     * The specific value that the Object being queried is bound to.
     * 
     * @return
     */
    String binding();

}
