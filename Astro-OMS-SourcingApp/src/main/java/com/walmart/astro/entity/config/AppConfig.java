package com.walmart.astro.entity.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
//@EnableWebSecurity
public class AppConfig {

//	@Autowired
//	public void doCustomAuthByRole(AuthenticationManagerBuilder builder) throws Exception {
//		builder.inMemoryAuthentication(). withUser("root").password("{noop}").roles("manager","admin");
//		builder.inMemoryAuthentication().withUser("user").password("{noop}").roles("customer");
//	}

//	@Bean
//	public SecurityFilterChain doCustomAuth(HttpSecurity security) throws Exception {
//		security.authorizeHttpRequests().requestMatchers("/api/v4/order/getAllOrders").hasAnyRole("manager")
//		.requestMatchers("/api/v4/order/save").hasAnyRole("admin")
//		.anyRequest().authenticated().and().formLogin();
//		return security.build();
//	}

//	@Bean
//	public Docket getDocketObj() {
//		return new Docket(DocumentationType.SWAGGER_2)
//		.select()
//		.apis(RequestHandlerSelectors.basePackage("com.walmart.astro.entity.controller"))
//		.paths(PathSelectors.regex("/api/v4/order/*"))
//		.build()
//		.useDefaultResponseMessages(true)
//		.apiInfo(getApiInfo());
//	}
//	
//	@Bean
//	public ApiInfo getApiInfo() {
//		return new ApiInfo("", "", "", "", "", "", "");
//	}
}
