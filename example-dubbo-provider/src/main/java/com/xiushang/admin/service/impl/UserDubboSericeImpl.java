package com.xiushang.admin.service.impl;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.xiushang.admin.service.UserDubboService;
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
import java.util.ArrayList;
import java.util.List;


@DubboService(filter = "userFilter",retries = 0)
public class UserDubboSericeImpl  implements UserDubboService, Serializable {
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

    @Transactional
    public void saveUser() {

        UserEntity userEntity = new UserEntity();
        userEntity.setName("name");
        userEntity.setLoginName("15921359796");
        userEntity.setMobile("15921359796");

        List<String> images = new ArrayList<>();
        images.add("https://profile-avatar.csdnimg.cn/9f172825429145ebada87e523f725279_web_yueqiang.jpg!3");

        userEntity.setImages(images);

        userDao.save(userEntity);

    }
}
