package org.sample.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.drools.runner.core.api.KieContainerBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.builder.Message.Level;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LocalContext.class)
@ActiveProfiles("local-test")
public class ExampleComponentTest {

	private static final Logger logger = LogManager.getLogger(ExampleComponentTest.class);

	@Autowired
	private KieContainerBuilder exampleKieContainerBuilder;

	/**
	 * This test method should compile all rules and catch any rules compilation
	 * errors. Fast.
	 */
	@Test
	public void shouldCreateKnowledgeBaseFromClasspathBuilder() {
		Assert.assertNotNull(exampleKieContainerBuilder);
		Assert.assertNotNull(exampleKieContainerBuilder.getKieContainer());
		KieContainer kieContainer = exampleKieContainerBuilder.getKieContainer();

		logger.info("KieBases: " + kieContainer.getKieBaseNames());
		Assert.assertNotNull(kieContainer.getKieBase("kbase1"));
		Assert.assertNotNull(kieContainer.newStatelessKieSession("exampleStatelessSession"));
		Assert.assertFalse(kieContainer.verify().hasMessages(Level.ERROR, Level.WARNING));

	}
}
