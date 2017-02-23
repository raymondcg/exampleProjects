package org.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sample.model.Customer;
import org.springframework.batch.item.ItemProcessor;

public class SampleProcessor implements ItemProcessor<Customer, Customer> {

    private static final Logger LOGGER = LogManager.getLogger( SampleProcessor.class );

    @Override
    public Customer process( Customer items ) throws Exception {
        LOGGER.debug( "Processing..." + items );
        return items;
    }

}
