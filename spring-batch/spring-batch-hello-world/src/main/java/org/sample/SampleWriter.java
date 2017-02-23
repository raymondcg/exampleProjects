package org.sample;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sample.model.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class SampleWriter implements ItemWriter<Customer> {

    private static final Logger LOGGER = LogManager.getLogger( SampleWriter.class );

    // Naughty!!!! this isn't thread safe and will nuke things bad.
    private boolean reinstated = false;

    @Autowired
    private FakeDao fakeDao;

    @Override
    public void write( List<? extends Customer> customers ) throws Exception {
        for ( Customer customer : customers ) {
            if ( customer.isReinstated() ) {
                reinstated = true;
            }
            if ( reinstated != customer.isReinstated() ) {
                LOGGER.debug( "Bad bad bad: reinstated: {} Customer: {})", reinstated, customer );
                fakeDao.countBad();
            } else {
                LOGGER.debug( "writing: " + customer );
            }
        }

    }

}
