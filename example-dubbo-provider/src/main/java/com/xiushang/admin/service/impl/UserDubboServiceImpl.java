package com.xiushang.admin.service.impl;


import com.xiushang.admin.service.UserDubboService;
import com.xiushang.admin.service.UserService;
import com.xiushang.entity.UserEntity;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@DubboService(filter = "userFilter",retries = 0)
public class UserDubboServiceImpl  implements UserDubboService, Serializable {

    @DubboReference(check = false)
    private UserService userService;

    @Transactional
    public List<UserEntity> getList() {

        List<UserEntity> list = userService.getList();
        if(list!=null){
            System.out.println(list.size());
        }

        return list;
    }

}
