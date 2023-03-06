package com.akash.userservice.Service;

import com.akash.userservice.Entity.User;
import com.akash.userservice.Repository.UserRepository;
import com.akash.userservice.ValueObject.Department;
import com.akash.userservice.ValueObject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User getUserById(Long userId) {
        return userRepository.findByUserId(userId);

    }


    public User saveUser(User user) {
        log.info("Inside saveUser of Userservice");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside the getUserWithDepartment method of userservice");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
