package com.xiushang.admin.service.impl;


import com.xiushang.admin.service.MarketingService;
import com.xiushang.entity.MarketingClientEntity;
import com.xiushang.entity.RoleEntity;
import com.xiushang.entity.ShopEntity;
import com.xiushang.entity.UserEntity;
import com.xiushang.framework.model.ShopStatusEnum;
import com.xiushang.jpa.repository.MarketingClientDao;
import com.xiushang.jpa.repository.RoleDao;
import com.xiushang.jpa.repository.ShopDao;
import com.xiushang.jpa.repository.UserDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@DubboService(filter = "userFilter",retries = 0)
public class MarketingServiceImpl implements MarketingService, Serializable {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private MarketingClientDao marketingClientDao;
    @Autowired
    private ShopDao shopDao;
    @Transactional
    public List<MarketingClientEntity> getList() {

        long count = userDao.count();
        UserEntity userEntity = null;
        if(count==0){
            userEntity = saveUser();
        }else{
            List<UserEntity> list = userDao.findByName("name");
            userEntity = list.get(0);
        }

        return marketingClientDao.findByUser(userEntity);
    }


    public UserEntity saveUser() {


        UserEntity userEntity = new UserEntity();
        userEntity.setName("name");
        userEntity.setLoginName("15921359796");
        userEntity.setMobile("15921359796");

        userEntity.setLastLoginDate(new Date());
        userEntity.setCreatedDate(new Date());
        userEntity.setUpdatedDate(new Date());

        List<String> images = new ArrayList<>();
        images.add("https://profile-avatar.csdnimg.cn/9f172825429145ebada87e523f725279_web_yueqiang.jpg!3");

        userEntity.setImages(images);

        userDao.save(userEntity);

        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setOwnerUser(userEntity);
        shopEntity.setMobile("mobile");
        shopEntity.setName("name");
        shopEntity.setCode("code");
        shopEntity.setContactsName("1");
        shopEntity.setAccountType(1);
        shopEntity.setShopStatus(ShopStatusEnum.SHOP_BASE);
        shopDao.save(shopEntity);

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setCode("10001");
        roleEntity.setName("管理员");

        List<String> imagesRole = new ArrayList<>();
        imagesRole.add("https://profile-avatar.csdnimg.cn/9f172825429145ebada87e523f725279_web_yueqiang.jpg!3");
        roleEntity.setImages(imagesRole);
        roleEntity.setCreatedDate(new Date());
        roleEntity.setUpdatedDate(new Date());

        roleDao.save(roleEntity);

        List<RoleEntity> list = new ArrayList<>();
        list.add(roleEntity);
        userEntity.setRoles(list);

        return userDao.save(userEntity);

    }

}
