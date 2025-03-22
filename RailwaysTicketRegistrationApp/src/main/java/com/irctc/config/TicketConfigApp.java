package com.irctc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
public class TicketConfigApp {
	
//    @Bean	
//	public SecurityFilterChain doCustomAuthentication(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.authorizeHttpRequests().requestMatchers("/getAllTickets").permitAll().anyRequest().authenticated().and().formLogin().and().oauth2Client();
//		return httpSecurity.build();
//	}
       	
//
//	// bean is equivalent to creating object of predefined class .
//	@Bean
//	public Docket getDocketObject() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(null);
//	}
//
//	@Bean
//	public ApiInfo getApiInfo() {
//		return null;
//	}
//
//	 this is a in-memory authentication where the authentication will happen based upon the role and password of the designated users .
//	@Autowired
//	public void authneticationManager(AuthenticationManagerBuilder managerBuilder) throws Exception {
//		managerBuilder.inMemoryAuthentication().withUser("gaurav").password("{noop}Qpalzm231998@").roles("customer", "admin");
//		managerBuilder.inMemoryAuthentication().withUser("yash").password("{noop}Test@123").roles("admin");
//	}
//
//	@Bean
//	public SecurityFilterChain modifyAuthentication(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests().requestMatchers("/getAllItems", "/save").hasRole("customer")
//				.requestMatchers("/findByPnrNumber").hasAnyRole("customer", "admin")
//				.anyRequest().authenticated().and()
//				.formLogin();
//		return http.build();
//	}
}