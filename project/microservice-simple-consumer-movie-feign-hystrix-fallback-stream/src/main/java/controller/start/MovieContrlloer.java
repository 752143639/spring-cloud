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
import bean.User;
import controller.feign.UserFeignClent;
   
@RestController
public class MovieContrlloer {
      
	private Logger log= LoggerFactory.getLogger(MovieContrlloer.class);
	 @Autowired
	 private RestTemplate re;
	 @Autowired
	 private DiscoveryClient dis;
	 @Autowired
	 private LoadBalancerClient rc;
	 @Autowired
	 private UserFeignClent ufc;
	 
 	 @RequestMapping("/user/{id}")
	 public User findById(@PathVariable Long id){
		 return this.re.getForObject("http://localhost:8010/"+id,User.class); 
	 }
	 
 	 @RequestMapping("/users/{id}")
	 public User findByIdForRibbon(@PathVariable Long id){
 		User u=	this.re.getForObject("http://microservice-simple-provider-user-eureka-mytadata/"+id,User.class);
		 return u; 
	 }
 	 
 	@RequestMapping("/user-instance")
 	 public List<ServiceInstance> showInfo() {
 		List<ServiceInstance> ss=this.dis.getInstances("microservice-simple-provider-user-eureka-mytadata");
 	    return ss;
 	  }
 	
	@RequestMapping("/log-instance")
	 public void showInfoForRibbon() {
		ServiceInstance ser=	 rc.choose("microservice-simple-provider-user-eureka-mytadata");
		
		log.info("{}{}{}{}",ser.getServiceId(),ser.getHost(),ser.getUri(),ser.getMetadata());
	    
	  }
	
	@RequestMapping("/feign/{id}")
	 public User findByIdForRibbonAndFeign(@PathVariable Long id){
		User u=ufc.findById(id);
		 return u; 
	 }
	 
	
}
