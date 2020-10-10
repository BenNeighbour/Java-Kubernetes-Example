package com.benneighbour.javakubernetes.gatewayservice;

import com.benneighbour.javakubernetes.gatewayservice.configuration.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.ForwardedHeaderFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class GatewayServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public FilterRegistrationBean forwardHeadersFilterBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new ForwardedHeaderFilter());
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}
