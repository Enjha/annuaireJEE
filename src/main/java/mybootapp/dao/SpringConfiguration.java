package mybootapp.dao;

import mybootapp.manager.DirectoryManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = SpringConfiguration.class)
public class SpringConfiguration {
}
