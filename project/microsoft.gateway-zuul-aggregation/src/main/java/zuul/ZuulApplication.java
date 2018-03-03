package zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulApplication {
    
	@Bean
	@LoadBalanced
	public RestTemplate restTemplates(){
		return new RestTemplate();
		
	}
	 public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuulApplication.class, args);
	}

}
