package kh.spring.exampleservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ExampleserviceConfiguration {

	@Bean
	public RestTemplate getRestClient() {
		RestTemplate restClient = new RestTemplate();
		return restClient;
	}

}
