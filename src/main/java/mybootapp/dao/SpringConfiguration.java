package mybootapp.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = { "mybootapp.dao", "mybootapp.manager" })
@EnableJpaRepositories(basePackageClasses = SpringConfiguration.class)
public class SpringConfiguration {
}
