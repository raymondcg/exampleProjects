package org.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sample.model.Customer;

public class FakeDao {

    private static final Logger LOGGER = LogManager.getLogger( FakeDao.class );

    private int counter = 0;
    private int reinstateRotation = 1;
    private int pumpCustomerCount = 10;
    private int countBad = 0;

    public Customer next() {
        if ( counter < pumpCustomerCount ) {
            counter++;

            Customer customer = new Customer();
            customer.setId( counter );
            if ( counter % reinstateRotation == 0 ) {
                customer.setReinstated( true );
                LOGGER.info( "Flagging customer to be reinstated: " + customer );
            }
            LOGGER.debug( "FakeDao Customer: " + customer );
            return customer;
        }
        return null;
    }

    public void countBad() {
        countBad++;
    }

    public int getBad() {
        return countBad;
    }

}
