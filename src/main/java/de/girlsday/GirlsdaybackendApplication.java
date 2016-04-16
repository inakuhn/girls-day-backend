package de.girlsday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import de.girlsday.config.PersistenceJPAConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("de.girlsday")
public class GirlsdaybackendApplication extends AbstractAnnotationConfigDispatcherServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GirlsdaybackendApplication.class, args);
	}

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{PersistenceJPAConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
}

	

