package de.girlsday.config;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
@ComponentScan("de.girlsday")
@PropertySource(ignoreResourceNotFound = true, value = {
        "classpath:AppConfig.properties", "classpath:AppConfig.${USERNAME}.properties", "${AppConfig}"
})
@EnableJpaRepositories(basePackages = "de.girlsday.dal")
public class PersistenceJPAConfig {

    @Value("${database.driver}")
    private String db_driver;
    
    @Value("${database.dialect}")
	private String db_dialect;

    @Value("${database.url}")
    private String db_url;

    @Value("${database.username}")
    private String db_user;

    @Value("${database.password}")
    private String db_password;

    @Value("${jpa.hbm2ddl.auto}")
    private String jpa_hbm2ddl_auto;


 

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        return conf;
    }
    


    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(db_driver);
        dataSource.setUrl(db_url);
        dataSource.setUsername(db_user);
        dataSource.setPassword(db_password);
        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabasePlatform(db_dialect);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPersistenceUnitName("test.persistence");
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("de.girlsday");

        factory.setJpaProperties(additionalProperties());

        factory.afterPropertiesSet();

        return factory.getObject();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", jpa_hbm2ddl_auto);
        return properties;
    }


//    @Bean
//    public ViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
 


}