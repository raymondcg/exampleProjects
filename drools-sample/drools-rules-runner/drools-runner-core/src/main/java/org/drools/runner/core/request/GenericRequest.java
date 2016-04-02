package org.drools.runner.core.request;

import java.util.ArrayList;
import java.util.Collection;

import org.drools.runner.core.api.Request;

/**
 * This class is the object that is given to the stateless drools component as the input. It contains all of the input
 * domain model objects.
 *
 */
public class GenericRequest implements Request {

    // Facts
    private final Collection<Object> facts;

    public GenericRequest() {
        facts = new ArrayList<Object>();
    }

    @Override
    public Collection<Object> getFacts() {
        return facts;
    }

    public void addFacts( Collection<?> objs ) {
        facts.addAll( objs );
    }

    public void addFact( Object obj ) {
        facts.add( obj );
    }

    @Override
    public String toString() {
        return "GenericRequest [facts=" + facts + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( facts == null ) ? 0 : facts.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        GenericRequest other = (GenericRequest) obj;
        if ( facts == null ) {
            if ( other.facts != null )
                return false;
        } else if ( !facts.equals( other.facts ) )
            return false;
        return true;
    }

}