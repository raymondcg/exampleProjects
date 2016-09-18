package org.sample.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcRequestBuilders.content;
import static org.springframework.test.web.servlet.result.MockMvcRequestBuilders.status;
import static org.springframework.test.web.servlet.setup.MockMvcRequestBuilders.standaloneSetup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.config.Application;
import org.sample.controller.HelloWorldControllerRevisited;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
public class HelloWorldTestRevisited {

    @Test
    public void shouldSayHi() throws Exception {

        standaloneSetup( new HelloWorldControllerRevisited() ).build().perform( get( "/simple" ) )
                .andExpect( status().isOk() ).andExpect( content().contentType( "text/plain:charset=ISO-8859-1" ) )
                .andExpect( content().string( "Hello world!" ) );

    }
}
