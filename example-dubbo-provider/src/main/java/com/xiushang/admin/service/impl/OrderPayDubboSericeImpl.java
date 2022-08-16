package com.xiushang.admin.service.impl;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.xiushang.admin.service.OrderPayDubboService;
import com.xiushang.common.user.vo.UserSearchVo;
import com.xiushang.common.utils.LazyLoadUtil;
import com.xiushang.entity.QUserEntity;
import com.xiushang.entity.UserEntity;
import com.xiushang.framework.entity.vo.PageTableVO;
import com.xiushang.jpa.repository.UserDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@DubboService(filter = "userFilter",retries = 0)
public class OrderPayDubboSericeImpl  implements OrderPayDubboService, Serializable {
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public PageTableVO getList() {

        UserSearchVo searchVo = new UserSearchVo();

        QUserEntity entity = QUserEntity.userEntity;
        BooleanExpression ex = entity.id.isNotNull();
        ex = ex.and(entity.loginName.like("%19888122579%"));

        Page<UserEntity> page = userDao.findAll(ex,searchVo.createPageRequest());

        LazyLoadUtil.fullLoad(page);

        PageTableVO vo = new PageTableVO(page, searchVo);

        return vo;
    }
}
