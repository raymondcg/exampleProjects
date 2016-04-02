package org.drools.runner.core.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.drools.runner.core.api.Request;
import org.drools.runner.core.exception.KnowledgeRuntimeException;
import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandUtils {

    private static final Logger logger = LoggerFactory.getLogger( CommandUtils.class );

    private static KieCommands commandFactory = KieServices.Factory.get().getCommands();

    /**
     * Creates query commands based on the {@link KieQuery} annotated fields in the Class parameter.
     * 
     */
    public static List<Command<?>> buildQueryCommands( Class<?> clazz ) {
        List<Command<?>> queryCommands = new ArrayList<Command<?>>();
        if ( clazz != null ) {
            Collection<Field> fields = getAllFields( clazz );
            for ( Field field : fields ) {
                KieQuery queryInfo = field.getAnnotation( KieQuery.class );
                if ( queryInfo != null ) {
                    String queryName = queryInfo.queryName();
                    queryCommands.add( commandFactory.newQuery( queryName, queryName ) );
                }
            }
        }
        return queryCommands;
    }

    /**
     * Creates setGlobal commands based on the {@link KieGlobal} annotated fields of the request object
     */
    public static List<Command<?>> buildGlobalCommands( Object request ) {
        List<Command<?>> globalCommands = new ArrayList<>();
        getAllFields( request.getClass() ).forEach( field -> {
            KieGlobal annotation = field.getAnnotation( KieGlobal.class );
            if ( annotation != null ) {
                String globalIdentifier = annotation.globalIdentifier();
                try {
                    Object property = PropertyUtils.getProperty( request, field.getName() );
                    globalCommands.add( commandFactory.newSetGlobal( globalIdentifier, property ) );
                } catch ( Exception e ) {
                    e.printStackTrace();
                    throw new KnowledgeRuntimeException( "Error creating Set Global query.", e );
                }
            }
        } );
        return globalCommands;
    }

    static Collection<?> extractCollectionFromExecutionResults( ExecutionResults executionResults, String queryName,
            String binding ) {
        Collection<Object> list = new ArrayList<Object>();
        if ( executionResults != null ) {
            QueryResults queryResult = (QueryResults) executionResults.getValue( queryName );
            if ( queryResult != null ) {
                for ( QueryResultsRow row : queryResult ) {
                    list.add( row.get( binding ) );
                }
            }
        }
        return list;
    }

    static Collection<Field> getAllFields( Class<?> clazz ) {
        Collection<Field> fields = new ArrayList<Field>();
        addFields( clazz, fields );
        Class<?> superClazz = clazz;
        while ( superClazz.getSuperclass() != null ) {
            superClazz = superClazz.getSuperclass();
            addFields( superClazz, fields );
        }
        return fields;
    }

    private static void addFields( Class<?> clazz, Collection<Field> fields ) {
        for ( Field field : clazz.getDeclaredFields() ) {
            fields.add( field );
        }
    }

    /**
     * Builds a BatchExecutionCommand from the arguments, adding any setGlobalCommands from the {@link KieGlobal}
     * annotated fields on the Request, inserts all facts from the Request, adds any queries configured via
     * {@link KieQuery{ on the ResponseClazz, and starts the process
     */
    public static BatchExecutionCommand createBatchExecutionCommand( Request request, String processId,
            Class<?> responseClazz, String lookup ) {
        List<Command<?>> commands = new ArrayList<Command<?>>();
        if ( request != null ) {
            commands.addAll( CommandUtils.buildGlobalCommands( request ) );

            Collection<Object> facts = request.getFacts();
            if ( facts != null ) {
                commands.add( commandFactory.newInsertElements( facts ) );
            }
        }
        if ( processId != null && !processId.isEmpty() ) {
            commands.add( commandFactory.newStartProcess( processId ) );
        }

        // TODO move to request as annotated KieGlobal
        // Adds a logger that can then be used by rules.
        commands.add( commandFactory.newSetGlobal( "logger", logger ) );

        commands.add( commandFactory.newFireAllRules() );

        // Creates commands to run the queries at the end of process
        commands.addAll( CommandUtils.buildGlobalCommands( responseClazz ) );

        return null == lookup ? commandFactory.newBatchExecution( commands )
                : commandFactory.newBatchExecution( commands, lookup );
    }

}
