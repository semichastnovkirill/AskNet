package org.communis.asknet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/static/**", "/webjars/**").permitAll()
            .antMatchers("/**").permitAll()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/admin/**").hasAnyRole("ADMIN")
            .antMatchers("/login").anonymous()
            .anyRequest().fullyAuthenticated();
        http
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
//            .successHandler(successLoginHandler())
            .permitAll();
        http
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .invalidateHttpSession(true)
            .permitAll();
    }


    @Bean
    public JdbcUserDetailsManager jdbcUserdetailService(@Qualifier("dataSource") DataSource dataSource) throws Exception {

        return new JdbcUserDetailsManagerConfigurer<>()
            .dataSource(dataSource)
            .withDefaultSchema()
            .getUserDetailsService();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService jdbcUserdetailService) throws Exception {
        auth.userDetailsService(jdbcUserdetailService).passwordEncoder(encoder());
    }

//    @Bean
//    public SuccessLoginHandler successLoginHandler() {
//        return new SuccessLoginHandler("/admin/main");
//    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
