package org.sample.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.sample.controller.HelloWorldController;
import org.springframework.http.MediaType;

public class HelloWorldTest {

    @Test
    public void shouldSayHi() throws Exception {

        standaloneSetup( new HelloWorldController() ).build().perform( get( "/simple" ).accept( MediaType.TEXT_PLAIN ) )
                .andExpect( status().isOk() ).andExpect( content().contentType( "text/plain;charset=ISO-8859-1" ) )
                .andExpect( content().string( "Hello world!" ) );

    }
}
