package org.sample.test;

import static org.springframework.test.web.servlet.result.MockMvcRequestBuilders.content;
import static org.springframework.test.web.servlet.result.MockMvcRequestBuilders.status;
import static org.springframework.test.web.servlet.setup.MockMvcRequestBuilders.standaloneSetup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.config.Application;
import org.sample.controller.HelloWorldController;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
public class HelloWorldTest {

    @Test
    public void shouldSayHi() throws Exception {

        standaloneSetup( new HelloWorldController() ).build()
                .perform( get( "/simple/revisited" ).accept( MediaType.TEXT_PLAIN ) ).andExpect( status().isOk() )
                .andExpect( content().contentType( "text/plain" ) )
                .andExpect( content().string( "Hello world revisited!" ) );

    }
}