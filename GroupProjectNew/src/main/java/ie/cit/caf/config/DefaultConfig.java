package ie.cit.caf.config;

	import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
	@Configuration
	@EnableAutoConfiguration
	@ComponentScan(basePackages = "ie.cit.caf.repository")
	@EnableTransactionManagement
	@Import({ ApplicationSecurity.class })
	public class DefaultConfig {
		//mkyong
	    @Bean
	    public SessionFactory sessionFactory() {
	            LocalSessionFactoryBuilder builder = 
			new LocalSessionFactoryBuilder(dataSource());
	            builder.scanPackages("ie.cit.caf.entity")
	                  .addProperties(getHibernateProperties());

	            return builder.buildSessionFactory();
	    }

	private Properties getHibernateProperties() {
	            Properties prop = new Properties();
	            prop.put("hibernate.format_sql", "true");
	            prop.put("hibernate.show_sql", "true");
	            prop.put("hibernate.dialect", 
	                "org.hibernate.dialect.MySQL5Dialect");
	            return prop;
	    }

	@Bean(name = "dataSource")
	public DataSource dataSource() {

		DataSource ds = new DataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/assignment");
		ds.setUsername("root");
		return ds;
	}

	//Create a transaction manager
//	@Bean
//	    public HibernateTransactionManager txManager() {
//	            return new HibernateTransactionManager(sessionFactory());
//	    }

	//@Bean
	//public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver 
//	                         = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/pages/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
	//}
		
	}


