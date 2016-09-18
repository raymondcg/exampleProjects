package org.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorldControllerRevisited {

    private static final Logger LOGGER = LoggerFactory.getLogger( HelloWorldControllerRevisited.class );

    @RequestMapping(value = "/simple/revisited", method = RequestMethod.GET, headers = "Accept=text/plain")
    public @ResponseBody String simple() {
        LOGGER.info( "hello world revisited" );
        return "Hello world revisited!";
    }
}
