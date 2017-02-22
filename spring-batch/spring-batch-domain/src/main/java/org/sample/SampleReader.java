package org.sample;

import org.sample.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

public class SampleReader implements ItemReader<Customer> {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleReader.class);

	@Autowired
	private FakeDao fakeDao;
	
	@Override
	public Customer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		Customer customer = fakeDao.next();
		LOGGER.debug("Reader: " + customer);
		return customer;
	}

}
