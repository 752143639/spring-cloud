package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import bean.User;

@RestController
public class MovieContrlloer {

	 @Autowired
	 private RestTemplate re;
 	 @GetMapping("/user/{id}")
	 public User findById(@PathVariable long id){
		 return this.re.getForObject("http://localhost:8010/"+id,User.class); 
	 }
	 
}
