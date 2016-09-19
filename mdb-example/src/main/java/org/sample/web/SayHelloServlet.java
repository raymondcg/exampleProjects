package org.sample.web;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/")
public class SayHelloServlet extends HttpServlet {

    private static final long serialVersionUID = 6570115036212268543L;
    private static final Logger LOGGER = LoggerFactory.getLogger( SayHelloServlet.class );

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        String name = req.getParameter( "name" ) != null ? req.getParameter( "name" ) : "michael";
        sendMessage( name );
        LOGGER.info( String.format( "check your console (%s, args )", name ) );

        // TODO need both logger and response writer?
        res.getWriter().println( String.format( "check your console (%s, args )", name ) );
    }

    void sendMessage( String name ) {
        String destinationName = "queue/helloQueue";
        Context ic;
        ConnectionFactory cf;
        Connection connection = null;

        try {
            ic = new InitialContext();

            cf = (ConnectionFactory) ic.lookup( "/ConnectionFactory" );
            Queue queue = (Queue) ic.lookup( destinationName );

            connection = cf.createConnection();
            Session session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );
            MessageProducer publisher = session.createProducer( queue );

            connection.start();

            TextMessage message = session.createTextMessage( name );
            publisher.send( message );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        } finally {
            if ( connection != null ) {
                try {
                    connection.close();
                } catch ( JMSException e ) {
                    throw new RuntimeException( e );
                }
            }
        }
    }
}
