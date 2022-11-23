package com.xiushang.admin.service.impl;


import com.xiushang.admin.service.UserDubboService;
import com.xiushang.admin.service.UserService;
import com.xiushang.common.user.vo.UserVo;
import org.apache.dubbo.config.annotation.DubboService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@DubboService(filter = "userFilter",retries = 0)
public class UserServiceImpl implements UserService, Serializable {

    public List<UserVo> getList() {

        List<UserVo> list = new ArrayList<>();

        UserVo userVo = new UserVo();
        userVo.setLoginName("loginName");
        userVo.setMobile("mobile");
        userVo.setName("name");

        list.add(userVo);

        return list;
    }

}
