package org.sample.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 'StrictMaxPool' will also need to be updated in the container, otherwise
 * session sizes configured in this call don't matter. Pool is defaulted to 15.
 * So only 15 would be processed at once. Note Max Sessions and StrictMaxPool
 * should be the same value to promote better processing.
 * 
 * If maxSessions is set to 25 and the pool size left at the default of 15. When
 * messages are being processed the number of instances will alternate between
 * 15 and 10, which is the difference between the maxSessions and the max size
 * parameters. So 15 messages will be processed, then 10, then 15, then 10,
 * repeating until the number of messages drops to 15 or below.
 *
 */
@MessageDriven(name = "HelloWorldExample", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/hellowQueue"),
		@ActivationConfigProperty(propertyName = "acknoledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "minSessions", propertyValue = "25"),
		@ActivationConfigProperty(propertyName = "maxSessions", propertyValue = "50") })
public class HelloWorldListener implements MessageListener {
	private static final Logger LOGGER = LogManager.getLogger(HelloWorldListener.class);

	@Override
	public void onMessage(Message inMessage) {
		TextMessage message = (TextMessage) inMessage;
		try {
			LOGGER.info(String.format("Hello, %s", message.getText()));
		} catch (JMSException e) {
			LOGGER.error("Error processing Message", e);
		}
	}

}
