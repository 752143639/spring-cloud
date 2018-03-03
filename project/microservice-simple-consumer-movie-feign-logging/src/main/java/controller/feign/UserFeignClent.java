package controller.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.User;
import controller.config.FeignLogConfiguration;
   
@FeignClient(name="microservice-simple-provider-user-eureka-mytadata", configuration=FeignLogConfiguration.class)
public interface UserFeignClent {
    @RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}
