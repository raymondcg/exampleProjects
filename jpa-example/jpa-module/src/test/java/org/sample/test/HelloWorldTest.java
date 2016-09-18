package org.sample.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.config.Application;
import org.sample.domain.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
public class HelloWorldTest {

    @Autowired
    private HelloWorldService helloWorldService;

    @Test
    public void shouldSayHi() {

        Assert.assertTrue( "Didn't Say Hello correctly.", helloWorldService.hello().equals( "hello" ) );

    }
}
