package com.itmuch.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itmuch.cloud.study.entity.User;
import com.itmuch.cloud.study.repository.UserRepository;
 
@Controller
public class UserController {
  
	@Autowired
	private  UserRepository userRepository;
 	@ResponseBody
 	@RequestMapping( value = "/{id}")
	public    User findById(@PathVariable Long id){
		User findOne=this.userRepository.findOne(id);
		return findOne ;
	}
}
