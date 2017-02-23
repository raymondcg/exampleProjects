package org.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO move to the spring batch 'jar', and swap to spring java context configuration.
public class App {

    private static final Logger LOGGER = LogManager.getLogger( App.class );

    public static void main( String[] args ) {

        String[] springConfig = { "spring/batch/jobs/job-hello-world.xml" };

        ApplicationContext context = new ClassPathXmlApplicationContext( springConfig );

        JobLauncher jobLauncher = (JobLauncher) context.getBean( "jobLauncher" );
        Job job = (Job) context.getBean( "helloWorldJob" );

        try {
            JobExecution execution = jobLauncher.run( job, new JobParameters() );
            LOGGER.info( "Exit Status: " + execution.getStatus() );
        } catch ( Exception e ) {
            LOGGER.error( "Program Explosion", e );
        }
        LOGGER.info( "Done" );

    }
}
