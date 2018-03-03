package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;

import bean.User;

@RestController
@EnableCircuitBreaker
public class MovieContrlloer {
     private static final Logger logger=LoggerFactory.getLogger(MovieContrlloer.class);
	 @Autowired
	 private RestTemplate re;
	 @Autowired
	 private LoadBalancerClient lbc;
	 
	 @HystrixCommand(fallbackMethod="findByIdFallBack" ,commandProperties={
			 @HystrixProperty(name="", value = "5000")
			 
	 })
 	 @GetMapping("/user/{id}")
	 public User findById(@PathVariable long id){
		 return this.re.getForObject("http://localhost:8010/"+id,User.class); 
	 }
	 
	  public User findByIdFallBack(Long id){
		  
		  User u=new User();
		  u.setId(-1L);
		  u.setName("默认用户");
		  return u;
	  } 
}
