package org.sample.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.sample.controller.HelloWorldControllerRevisited;

public class HelloWorldRevisitedTest {

    @Test
    public void shouldSayHi() throws Exception {

        standaloneSetup( new HelloWorldControllerRevisited() ).build().perform( get( "/simple/revisited" ) )
                .andExpect( status().isOk() ).andExpect( content().contentType( "text/plain;charset=ISO-8859-1" ) )
                .andExpect( content().string( "Hello world revisited!" ) );

    }
}
