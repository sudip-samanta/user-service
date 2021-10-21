package com.fistic.user.model;

import com.fistic.user.entity.User;
import lombok.Data;

@Data
public class ResponseTemplateVO {

    private User user;
    private Department department;
}
