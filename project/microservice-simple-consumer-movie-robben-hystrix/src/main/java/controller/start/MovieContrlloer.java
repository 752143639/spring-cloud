package controller.start;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import bean.User;
import controller.feign.UserFeignClent;
   
@RestController
public class MovieContrlloer {
      
	private Logger log= LoggerFactory.getLogger(MovieContrlloer.class);
	 @Autowired
	 private RestTemplate re;
 
	 @HystrixCommand(fallbackMethod="findByIdFallBack")
 	 @RequestMapping("/users/{id}")
	 public User findByIdForRibbon(@PathVariable Long id){
 		User u=	this.re.getForObject("http://microservice-simple-provider-user-eureka-mytadata/"+id,User.class);
		 return u; 
	 }
    public User findByIdFallBack(Long id){
    	
    	User u=new User ();
    	u.setId(-1l);
    	u.setName("默认用户");
		return null;
    	
    	
    }
	 
	
}
