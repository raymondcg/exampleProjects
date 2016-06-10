package org.sample.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sample.domain.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldTest {

    @Autowired
    private HelloWorldService helloWorldService;

    @Before
    public void setup() {

        // TODO make this test use proper wiring.
        helloWorldService = new HelloWorldService();
    }

    @Test
    public void shouldSayHi() {

        Assert.assertTrue( "Didn't Say Hello correctly.", helloWorldService.hello().equals( "hello" ) );

    }
}
