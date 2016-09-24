package org.sample.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final Logger LOGGER = LogManager.getLogger( HelloWorldController.class );

    @RequestMapping("/simple")
    public @ResponseBody String simple() {
        LOGGER.info( "hello world {}", "Lazy Patterns FTW" );
        return "Hello world!";
    }
}
