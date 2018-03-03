package jxjava.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import dto.User;
import rx.Observable;

public class AgggregationService {
	
	@Autowired
	private RestTemplate restTemplates;
	@HystrixCommand(fallbackMethod="hyfallback") 
	public Observable<User> getUserById(Long id){
       return Observable.create(observer -> {
    	   
    	   
    	   
    	   
       });
 
	}
 
}
