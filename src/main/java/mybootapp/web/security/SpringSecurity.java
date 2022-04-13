package mybootapp.web.security;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import mybootapp.model.XUser;
import mybootapp.repo.XUserRepository;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    XUserRepository userRepo;

    @PostConstruct
    public void init() {
        var encoder = passwordEncoder();
        var aa = new XUser("aaa", encoder.encode("aaa"), Set.of("ADMIN", "USER"));
        var bb = new XUser("bbb", encoder.encode("bbb"), Set.of("USER"));
        userRepo.save(aa);
        userRepo.save(bb);
        System.out.println("--- INIT SPRING SECURITY");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // -- ne pas activer la protection CSRF
                //.csrf().disable()
                // -- URL sans authentification
                .authorizeRequests()//
                .antMatchers("/", "/webjars/**", //
                        "/home", "/login", //
                        "/calculator/**")//
                .permitAll()//
                .antMatchers("/simple-user/**")//
                .hasAnyAuthority("ADMIN") /// ****** NOUVEAU
                // -- Les autres URL nécessitent une authentification
                .anyRequest().authenticated()
                // -- Nous autorisons un formulaire de login
                .and().formLogin().permitAll()
                // -- Nous autorisons un formulaire de logout
                .and().logout().permitAll();
     
    }

    @Autowired
    UserDetailsService myUserDetailsService;

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}