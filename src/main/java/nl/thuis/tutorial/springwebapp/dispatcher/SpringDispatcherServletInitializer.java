package nl.thuis.tutorial.springwebapp.dispatcher;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import nl.thuis.tutorial.springwebapp.config.SpringJpaConfig;
import nl.thuis.tutorial.springwebapp.config.SpringMvcConfig;

public class SpringDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private static final String[] SERVLET_MAPPINGS = {"/"};
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * This is equal to the dispatcher-servlet that is defined in the web.xml
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMvcConfig.class, SpringJpaConfig.class};
	}

	/**
	 * This is equal to the dispatcher-servlet-mappings that are defined in the web.xml
	 */
	@Override
	protected String[] getServletMappings() {
		return SERVLET_MAPPINGS;
	}

}
