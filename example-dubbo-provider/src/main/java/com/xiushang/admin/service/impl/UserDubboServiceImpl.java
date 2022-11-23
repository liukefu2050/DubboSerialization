package com.xiushang.admin.service.impl;


import com.xiushang.admin.service.UserDubboService;
import com.xiushang.admin.service.UserService;
import com.xiushang.common.user.vo.UserVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import java.io.Serializable;
import java.util.List;


@DubboService(filter = "userFilter",retries = 0)
public class UserDubboServiceImpl  implements UserDubboService, Serializable {

    @DubboReference(check = false)
    private UserService userService;

    public List<UserVo> getList() {

        List<UserVo> list = userService.getList();
        if(list!=null){
            System.out.println(list.size());
        }

        return list;
    }

}
