package org.drools.runner.core.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kie.api.runtime.ExecutionResults;

/**
 * Default Transformer. This class will set the Reponse based upon the
 * {@link KieQuery} annotation on a method in the response.
 *
 */
public class ReflectiveExecutionResultsTransformer {

	private static final Logger logger = LogManager.getLogger(ReflectiveExecutionResultsTransformer.class);

	public ReflectiveExecutionResultsTransformer() {

	}

	/**
	 * Produces a Reponse instance with all {@link KieQuery} annotated bean
	 * properties populated. Annotated fields in the response class are hydrated
	 * via bean accessor methods. Expect a NullPointerException if Response
	 * class does not expose @KieQuery fields via setter method. Any errors that
	 * may occur are caught and are only logged, no exceptions are rethrown.
	 * <p>
	 * Returns null if either argument is null
	 */
	public static <Response> Response transform(ExecutionResults results, Class<Response> responseClazz) {
		if (responseClazz == null || results == null) {
			logger.error("Reponse class or results null.");
			return null;
		}

		Response response = null;
		try {
			response = responseClazz.newInstance();
		} catch (InstantiationException e) {
			logger.error(
					String.format("New instance of response class could not be created: %s", responseClazz.getName()));
		} catch (IllegalAccessException e) {
			logger.error(
					String.format("New instance of response class could not be created: %s", responseClazz.getName()));
		}

		for (Field field : CommandUtils.getAllFields(responseClazz)) {
			KieQuery queryInfo = field.getAnnotation(KieQuery.class);
			if (queryInfo != null) {
				String queryName = queryInfo.queryName();
				String binding = queryInfo.binding();
				Class<?> type = field.getType();
				if (Collection.class.equals(type)) {
					try {
						Collection<?> list = CommandUtils.extractCollectionFromExecutionResults(results, queryName,
								binding);
						if (list == null) {
							logger.warn(String.format("Query results were empty for query: %s", queryName));
						}
						PropertyUtils.setProperty(response, field.getName(), list);
					} catch (IllegalAccessException e) {
						logger.error(String.format("Could not set results on property: %s", field.getName()), e);
					} catch (InvocationTargetException e) {
						logger.error(String.format("Could not set results on property: %s", field.getName()), e);
					} catch (NoSuchMethodException e) {
						logger.error(String.format("Could not set results on property: %s", field.getName()), e);
					}

				} else {
					logger.error(String.format(
							"QueryInfo annotation cannot be used on %s. It can only be used on fields which are of Type Collection",
							field.getName()));
				}
			}
		}

		return response;
	}

}
