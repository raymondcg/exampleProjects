package org.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControllerRevisited {

    private static final Logger LOGGER = LoggerFactory.getLogger( HelloWorldControllerRevisited.class );

    @RequestMapping(value = "/simple/revisited", method = RequestMethod.GET, headers = "Accept=text/plain")
    public @ResponseBody String simple() {
        LOGGER.info( "hello world revisited" );
        return "Hello world revisited!";
    }
}
