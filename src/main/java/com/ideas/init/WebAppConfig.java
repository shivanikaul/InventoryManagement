package com.ideas.init;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("com.ideas")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:Application.properties")
public class WebAppConfig {

	private static final String DB_URL = "db.url";
	private static final String DB_DRIVER = "db.driver";
	private static final String DB_USER_NAME = "db.username";
	private static final String DB_PASSWORD = "db.password";
	
	private static final String DB_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String DB_SHOW_SQL="hibernate.show_sql";
	private static final String DB_ENTITY_PACKAGE="entitymanager.packages.to.scan";
	
	@Resource
	private Environment env;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getRequiredProperty(DB_URL));
        dataSource.setDriverClassName(env.getRequiredProperty(DB_DRIVER));
        dataSource.setUsername(env.getRequiredProperty(DB_USER_NAME));
        dataSource.setPassword(env.getRequiredProperty(DB_PASSWORD));
        
        return dataSource;

	}

	
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean localsessionFactory = new LocalSessionFactoryBean();
		localsessionFactory.setDataSource(dataSource());
		localsessionFactory.setPackagesToScan(env.getRequiredProperty(DB_ENTITY_PACKAGE));
		localsessionFactory.setHibernateProperties(hibernateProperties());
		return localsessionFactory;
	}


	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(DB_HIBERNATE_DIALECT,env.getProperty(DB_HIBERNATE_DIALECT));
		properties.put(DB_SHOW_SQL, env.getProperty(DB_SHOW_SQL));
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager()
	{
		HibernateTransactionManager hibenateTransactionManager = new HibernateTransactionManager();
		hibenateTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hibenateTransactionManager;
	}
	
	@Bean
	public UrlBasedViewResolver setUpViewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
}
