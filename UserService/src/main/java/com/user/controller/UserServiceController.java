package com.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;
import com.user.vo.ResponseTemplateVO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserServiceController {
	
	@Autowired
	private UserService userService;
	
	@Value("${global.limit.min}")
	private String limit;
	
	@Value("${user.service.limit}")
	private String locallimit;
	
	@PostMapping("/")
	public User saveUsers(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping("/{id}")
	@CircuitBreaker(name = "USER-SERVICE" ,fallbackMethod = "fallbackMethod")
	public ResponseTemplateVO getUser(@PathVariable Long id) throws Exception {
		//return userService.getUserByUserId(id);
		return userService.getUserDepartment(id);
	}
	
	@GetMapping("/department/{id}")
	public ResponseTemplateVO getUserDepartment(@PathVariable Long id) {
		return userService.getUserDepartment(id);
	}
	
	public ResponseTemplateVO fallbackMethod(Exception ex) {
		
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = new User();
		user.setUserName("This is from fallback");
		responseTemplateVO.setUser(user);
		
		return responseTemplateVO;
	}
	
	@GetMapping("/limit")
	public ResponseEntity<String> getLimit(HttpServletRequest request){
		String limits="";
		limits="Response From:"+request.getServerName()+":"+request.getServerPort()+"\n Global Limit:"+limit+" Local limit:"+locallimit;
		
		return ResponseEntity.status(HttpStatus.OK).body(limits);
	}
}
