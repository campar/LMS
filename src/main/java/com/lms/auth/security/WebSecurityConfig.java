package com.lms.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lms.auth.security.jwt.JwtAuthEntryPoint;
import com.lms.auth.security.jwt.JwtAuthTokenFilter;
import com.lms.auth.security.services.UserDetailsServiceImpl;
 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
 
    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;
 
    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }
 
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
 
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().
                authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/movies" + "/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    
//    @Override
//  	protected void configure(HttpSecurity http) throws Exception {
//    	   http
//		.csrf().disable()
//		    // make sure we use stateless session; session won't be used to store user's state.
//	 	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 	
//		.and()
//		    // handle an authorized attempts 
//		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//		.and()
//		   // Add a filter to validate the tokens with every request
//		   .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
//		// authorization requests config
//		.authorizeRequests()
//		   // allow all who are accessing "auth" service
//		   .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()  
//		   // must be an admin if trying to access admin area (authentication is also required here)
//		   .antMatchers("/movies" + "/admin/**").hasRole("ADMIN")
//		   // Any other request must be authenticated
//		   .anyRequest().authenticated(); 
//	}
}
