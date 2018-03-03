package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	@Value("${profile}")
   private  String profile ;
	
	 @RequestMapping(value="/profile")
	public String hello(){
		return this.profile;
 
	}
}
