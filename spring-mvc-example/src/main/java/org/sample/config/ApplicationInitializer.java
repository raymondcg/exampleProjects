package org.sample.config;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { Application.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
}
