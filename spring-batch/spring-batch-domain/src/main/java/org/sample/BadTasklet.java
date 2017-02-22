package org.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class BadTasklet implements Tasklet {

	private static final Logger LOGGER = LoggerFactory.getLogger(BadTasklet.class);

	@Autowired
	private FakeDao fakeDao;
	
	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception{
		LOGGER.info("Count of Bad conditions: "+fakeDao.getBad());
		return null;
	}
	
}
