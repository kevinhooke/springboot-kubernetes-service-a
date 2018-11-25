package kh.spring.exampleservice.rest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import kh.spring.exampleservice.domain.HelloResult;
import kh.spring.exampleservice.domain.ServiceToServiceResult;

@RestController
public class ExampleRestController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/hello")
	public HelloResult getHello() throws UnknownHostException {
		HelloResult result = new HelloResult();
		result.setMessage("hello !updated! from exampleservice-a on " + InetAddress.getLocalHost() );
		return result;
	}
	
	@GetMapping("/servicetoservice")
	public ServiceToServiceResult getResult() throws UnknownHostException {
		ServiceToServiceResult result = new ServiceToServiceResult();
		result.setMessageA("hello from exampleservice-a on " + InetAddress.getLocalHost() );
		
		//call service-b
		HelloResult resultB = this.restTemplate.getForObject("http://exampleservice-b.default.svc.cluster.local:8080/example-b/v1/hello", HelloResult.class);
		result.setMessageB(resultB.getMessage());
		return result;
	}
	
}
