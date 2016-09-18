package org.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger( HelloWorldController.class );

    @RequestMapping("/simple")
    public @ResponseBody String simple() {
        LOGGER.info( "hello world" );
        return "Hello world!";
    }
}
