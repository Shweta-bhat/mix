package com.fable.weatherall.Configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fable.weatherall.Services.CustomSuccessHandler;
import com.fable.weatherall.Services.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http.csrf(c -> c.disable())
	        .authorizeHttpRequests(request -> request
	                .requestMatchers("/home", "/signup","/userlogin", "/login","/admin/authenticate","/Homepage/images/**","/api/config","/Signup/**","/Login/**","/admin/registerAdmin","/save").permitAll()
	                .requestMatchers("/getfoods/**","/clothing/**","/outdoor/**","/travel/**").permitAll()
//	                .requestMatchers("/login","/u_dashboard").authenticated()
	                .requestMatchers("/u_dashboard").hasAuthority("user")
	                .requestMatchers("/admin/**").hasAuthority("admin")
	                .anyRequest().authenticated())
	        
	            .formLogin(form -> form
	                .loginPage("/userlogin").loginProcessingUrl("/userlogin")
	                .successHandler(new CustomSuccessHandler()).permitAll());
	        
//	            .logout(form -> form
//	                .invalidateHttpSession(true).clearAuthentication(true)
//	                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//	                .logoutSuccessUrl("/login?logout").permitAll());

	        return http.build();

	    }
	
	
	@Autowired
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

}