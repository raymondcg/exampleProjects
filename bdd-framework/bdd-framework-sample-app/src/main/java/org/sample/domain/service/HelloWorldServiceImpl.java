package org.sample.domain.service;

import org.springframework.stereotype.Service;

//@Transactional
@Service
public class HelloWorldServiceImpl {

    public String hello() {
        return "hello";
    }

}
