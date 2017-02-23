package org.sample.config;

import org.sample.SampleReader;
import org.sample.SampleWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    @JobScope
    public SampleReader itemReader() {
        return new SampleReader();
    }

    @Bean
    @StepScope
    public SampleWriter itemWriter( @Value("#{jobParameters[fail]}") Boolean fail ) {
        SampleWriter itemWriter = new SampleWriter();
        // itemWriter.setFail(fail);
        return itemWriter;
    }

    @Bean
    public Step step1() {
        return null; // stepBuilderFactory.get("step1").<String,
                     // Object>chunk(5).reader(itemReader()).writer(itemWriter(null)).build();
    }

    @Bean
    public Job javaJob() {
        return jobBuilderFactory.get( "javaJob" ).start( step1() ).build();
    }
}