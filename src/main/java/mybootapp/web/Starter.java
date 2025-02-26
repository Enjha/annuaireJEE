package mybootapp.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication(scanBasePackages= {"mybootapp.dao", "mybootapp.manager", "mybootapp.web"})
@EntityScan(basePackages = "mybootapp.model")
@EnableTransactionManagement
@Configuration
public class Starter extends SpringBootServletInitializer implements WebMvcConfigurer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Starter.class);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor());
	}

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("--- addResourceHandlers");
		registry.addResourceHandler("/webjars/**")//
				.addResourceLocations("/webjars/");
	}

	@Override
	// Pour activer les variables matrix
	public void configurePathMatch(PathMatchConfigurer configurer) {
		var urlPathHelper = new UrlPathHelper();
		// Nous gardons le contenu après le point virgule
		urlPathHelper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(urlPathHelper);
	}

	@Bean("messageSource")
	public MessageSource messageSource() {
		var r = new ReloadableResourceBundleMessageSource();
		r.setBasenames("classpath:person", "classpath:messages");
		return r;
	}

	@Override
	public LocalValidatorFactoryBean getValidator() {
		var factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource());
		return factory;
	}
}
