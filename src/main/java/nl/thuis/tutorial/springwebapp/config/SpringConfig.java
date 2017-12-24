package nl.thuis.tutorial.springwebapp.config;


import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration // Its a configuration class
@EnableWebMvc  // This annotation is equal to mvc:annotation-driven tag
@ComponentScan(basePackages= {"nl.thuis.tutorial.springsecurity.controller" })
public class SpringConfig implements WebMvcConfigurer {

	private static final String RESOLVER_PREFIX = "/WEB-INF/view/";
	private static final String RESOLVER_SUFFIX = ".jsp";
	private static final String RESOURCE_HANDLER = "/resources/**";
	private static final String RESOURCE_LOCATION = "/resources/";
	
	@Autowired
	private Environment env;
	
    @Bean
    public DataSource dataSource() {
    	ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
			dataSource.setDriverClass(env.getRequiredProperty("database.driver"));
	        dataSource.setJdbcUrl(env.getRequiredProperty("database.url"));
	        dataSource.setUser(env.getRequiredProperty("database.user"));
	        dataSource.setPassword(env.getRequiredProperty("database.password"));
	        dataSource.setMinPoolSize(env.getRequiredProperty("c3p0.minpoolsize", Integer.class));
	        dataSource.setMaxPoolSize(env.getRequiredProperty("c3p0.maxpoolsize", Integer.class));
	        dataSource.setMaxIdleTime(env.getRequiredProperty("c3p0.maxidletime", Integer.class));
		} catch (IllegalStateException | PropertyVetoException e) {
			e.printStackTrace();
		}        
        return dataSource;
    }
	
	/**
	 * 	This bean is the view resolver that looks for the jsp-files
	 * @return ViewResolver-Object
	 */
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver(RESOLVER_PREFIX, RESOLVER_SUFFIX);
	}
	
	/** 
	 * This method is for adding the static content to application 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(RESOURCE_HANDLER).addResourceLocations(RESOURCE_LOCATION);
	}
	
	
}
