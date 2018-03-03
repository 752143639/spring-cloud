package controller.feign;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.User;

 public interface UserFeignClent {
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public User findById(@PathVariable("id") Long id);
}
