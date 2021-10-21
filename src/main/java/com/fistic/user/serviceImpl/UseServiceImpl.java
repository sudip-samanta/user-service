package com.fistic.user.serviceImpl;

import com.fistic.user.entity.User;
import com.fistic.user.model.Department;
import com.fistic.user.model.ResponseTemplateVO;
import com.fistic.user.repository.UserRepository;
import com.fistic.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UseServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService.");
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService.");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();

        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/v1/department/" + user.getDepartmentId(), Department.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
