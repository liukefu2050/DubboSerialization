package com.xiushang.admin.service;


import com.xiushang.common.user.vo.UserVo;
import com.xiushang.entity.UserEntity;

import java.util.List;

public interface UserDubboService {
    List<UserEntity> getList();

}
