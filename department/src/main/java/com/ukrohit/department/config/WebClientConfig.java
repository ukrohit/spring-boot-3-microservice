package com.ukrohit.department.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.ukrohit.department.client.EmployeeClient;

@Configuration
public class WebClientConfig {
	
	@Autowired
	private LoadBalancedExchangeFilterFunction filterFunction;
	
	@Bean
	public WebClient employeeWebClient()
	{
		return WebClient.builder()
				.baseUrl("http://employee-service")
				.filter(filterFunction)
				.build();
	}
	
	@Bean
	public EmployeeClient employeeClient()
	{
		HttpServiceProxyFactory httpProxyFactory=HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(employeeWebClient()))				
				.build();
		
		return httpProxyFactory.createClient(EmployeeClient.class);
	}
	

}
