package com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cn.bean.User;

@Controller
public class MovieController {

	@Autowired
	private RestTemplate restTemplate ;
	
	@ResponseBody
	@RequestMapping (value="/user/{id}")
	public User FindId(@PathVariable Long id){
		User u= this.restTemplate.getForObject("http://localhost:8000/"+id,User.class);
		return u;
 		
	}
	
}
