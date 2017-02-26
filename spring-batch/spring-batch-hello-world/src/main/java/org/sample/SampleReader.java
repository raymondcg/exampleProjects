package org.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sample.model.Customer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class SampleReader implements ItemReader<Customer> {

    private static final Logger LOGGER = LogManager.getLogger( SampleReader.class );

    private FakeDao fakeDao;

    @Override
    public Customer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Customer customer = fakeDao.next();
        LOGGER.debug( "Reader: " + customer );
        return customer;
    }

    public FakeDao getFakeDao() {
        return fakeDao;
    }

    public void setFakeDao( FakeDao fakeDao ) {
        this.fakeDao = fakeDao;
    }

}
