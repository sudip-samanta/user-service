package com.fistic.user.service;

import com.fistic.user.entity.User;
import com.fistic.user.model.ResponseTemplateVO;

public interface UserService {
    User saveUser(User user);

    ResponseTemplateVO getUserWithDepartment(Long userId);
}
