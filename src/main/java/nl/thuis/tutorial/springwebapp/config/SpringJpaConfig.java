package nl.thuis.tutorial.springwebapp.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration // Its a configuration class
@EnableTransactionManagement
@ComponentScan(basePackages= {"nl.thuis.tutorial.springwebapp.entity"})
@PropertySource("classpath:application.properties")
public class SpringJpaConfig {

	@Autowired
	private Environment env;
	
	/**
	 * This method sets up the datasource
	 * @return datasource-object
	 */
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
     * Set up Hibernate Session Factory
     * @return LocalSessionFactoryBean-object
     */
    @Bean 
    public LocalSessionFactoryBean hibernateSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    
    /**
     * Set up Hibernate Transaction Manager
     * @param sessionFactory
     * @return HibernateTransactionManager-object
     */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
    
    /**
     * This method is setting the hibernate properties
     * @return
     */
    private Properties hibernateProperties() {
    	Properties properties = new Properties();
    	properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
    	properties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.showsql"));
    	
    	return properties;
    }
}
