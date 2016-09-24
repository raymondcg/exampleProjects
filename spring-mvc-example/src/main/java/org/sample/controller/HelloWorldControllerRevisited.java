package org.sample.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControllerRevisited {

    private static final Logger LOGGER = LogManager.getLogger( HelloWorldControllerRevisited.class );

    @RequestMapping(value = "/simple/revisited", method = RequestMethod.GET, headers = "Accept=text/plain")
    public @ResponseBody String simple() {
        LOGGER.info( "hello world revisited {}", "Lazy Patterns FTW" );
        return "Hello world revisited!";
    }
}
