package nl.thuis.tutorial.springwebapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration // Its a configuration class
@EnableWebMvc  // This annotation is equal to mvc:annotation-driven tag
@EnableAspectJAutoProxy // This annotation enables using Spring Aop by creating proxies. This is equal to aop:aspectj-autoproxy tag
@ComponentScan(basePackages= {"nl.thuis.tutorial.springwebapp.controller", "nl.thuis.tutorial.springwebapp.repository.impl", 
								"nl.thuis.tutorial.springwebapp.service.impl", "nl.thuis.tutorial.springwebapp.aspect" })
public class SpringMvcConfig implements WebMvcConfigurer {

	private static final String ROOT = "/";
	private static final String HOME_PAGE = "index";

	private static final String RESOLVER_PREFIX = "/WEB-INF/view/";
	private static final String RESOLVER_SUFFIX = ".jsp";

	private static final String RESOURCE_HANDLER = "/resources/**";
	private static final String RESOURCE_LOCATION = "/resources/";

	/**
	 * This method can be used for setting home page
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController(ROOT).setViewName(HOME_PAGE);
	}

	/**
	 * This bean is the view resolver that looks for the jsp-files
	 * 
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
