package com.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.repository.UserServiceRepository;
import com.user.vo.Department;
import com.user.vo.ResponseTemplateVO;

@Service
public class UserService {

	@Autowired
	private UserServiceRepository userServiceRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User save(User user) {
		return userServiceRepository.save(user);
	}
	
	public User getUserByUserId(Long ID) throws Exception {
		User user = null;
		Optional<User> optional = userServiceRepository.findById(ID);
		if(optional.isPresent()) {
			user=optional.get();
		}else {
			throw new Exception("User is not found");
		}
		return user;
	}

	public ResponseTemplateVO getUserDepartment(Long id) {
		ResponseTemplateVO responseTemplateVO= new ResponseTemplateVO();
		Optional<User> optional = userServiceRepository.findById(id);
		User user = optional.get();
		responseTemplateVO.setUser(user);
		System.out.println("http://DEPARTMENT-SERVICE/departments/"+user.getUserDepartmentId());
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getUserDepartmentId(), Department.class);
		
		responseTemplateVO.setDepartment(department);
		
		return responseTemplateVO;
	}
}
