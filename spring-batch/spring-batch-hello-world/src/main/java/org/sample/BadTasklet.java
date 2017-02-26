package org.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class BadTasklet implements Tasklet {

    private static final Logger LOGGER = LogManager.getLogger( BadTasklet.class );

    private FakeDao fakeDao;

    @Override
    public RepeatStatus execute( StepContribution arg0, ChunkContext arg1 ) throws Exception {
        LOGGER.info( "Count of Bad conditions: " + fakeDao.getBad() );
        return null;
    }

    public FakeDao getFakeDao() {
        return fakeDao;
    }

    public void setFakeDao( FakeDao fakeDao ) {
        this.fakeDao = fakeDao;
    }

}
