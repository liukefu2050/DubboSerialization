package com.xiushang.admin.service.impl;


import com.xiushang.admin.service.OrderPayDubboService;
import com.xiushang.common.user.vo.UserSearchVo;
import com.xiushang.common.utils.BaseServiceImpl;
import com.xiushang.common.utils.LazyLoadUtil;
import com.xiushang.entity.UserEntity;
import com.xiushang.framework.entity.vo.PageTableVO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@DubboService(filter = "userFilter",retries = 0)
public class OrderPayDubboSericeImpl extends BaseServiceImpl<UserEntity> implements OrderPayDubboService, Serializable {

    @Transactional(readOnly = true)
    public PageTableVO getList() {

        UserSearchVo searchVo = new UserSearchVo();
        searchVo.setLoginName("19888122579");

        PageTableVO page = userService.findPageList(searchVo);
        LazyLoadUtil.fullLoad(page);

        return page;
    }
}
