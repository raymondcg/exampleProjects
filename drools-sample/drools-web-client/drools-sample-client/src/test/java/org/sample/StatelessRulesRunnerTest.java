package org.sample;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.drools.runner.core.api.RulesRunner;
import org.drools.runner.core.request.GenericRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.context.LocalContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Since the rules runner and Stateless BRMS code is generic, it is reusable.
 * Beyond defining the dependency injection to wire everything together, the
 * only thing a developer has to implement is the response object, the domain
 * model, and the rules.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LocalContext.class)
@ActiveProfiles("local-test")
public class StatelessRulesRunnerTest {

	@Autowired
	private RulesRunner rulesRunner;

	@Test
	public void shouldAutowireRulesRunner() {
		assertNotNull(rulesRunner);
	}

	/**
	 * Tests to ensure that the stateless drools context is step and building
	 * correctly. Great for detecting rules errors early.
	 * 
	 */
	@Test
	public void shouldRunRulesWithOutException() {
		// Arrange / Data In
		GenericRequest request = new GenericRequest();
		request.addFact("New Fact 1");
		request.addFact("New Fact 2");

		// Act / Run Rules
		ExampleResponse response = rulesRunner.execute(request, "example.process", ExampleResponse.class,
				Deployment.KSESSION);

		// Assert / Data Out
		assertNotNull(response);
		Collection<Fallout> fallouts = response.getFallout();
		// Validate rules response
		assertNotNull(fallouts);
		Assert.assertTrue("Fallout count not correct", fallouts.size() == 1);
		Fallout fallout = fallouts.iterator().next();
		Assert.assertTrue("Fallout count not correct fallout message",
				"opps I hit it again".equals(fallout.getMessage()));
	}

}