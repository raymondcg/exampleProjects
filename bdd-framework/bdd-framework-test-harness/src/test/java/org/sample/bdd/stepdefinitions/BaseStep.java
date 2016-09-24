package org.sample.bdd.stepdefinitions;

import java.util.Collection;

import org.sample.config.Application;
import org.sample.domain.api.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/*
 * This is a base class to be used by step definition classes. This class defines the context details, and wires in services, repositories, etc.
 */
@ContextConfiguration(classes = { Application.class })
public abstract class BaseStep {

    @Autowired
    protected UserDao userDao;

    /**
     * This method takes a collection and converts it into a string with one element per line. Typically used to print
     * collections quickly.
     * 
     * 
     */
    // TODO use string builder.....
    protected <T> String collectionToString( Collection<T> items ) {
        String print = "";
        print += "\n";
        for ( T item : items ) {
            print += item + "\n";
        }
        return print;
    }
}
