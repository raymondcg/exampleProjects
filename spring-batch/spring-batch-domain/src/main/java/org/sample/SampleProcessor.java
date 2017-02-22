package org.sample;

import org.sample.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class SampleProcessor implements ItemProcessor<Customer, Customer> {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleProcessor.class);

	@Override
	public Customer process(Customer items) throws Exception {
		LOGGER.debug("Processing..." + items);
		return items;
	}

}
