package com.xiushang.jpa.repository;

import com.xiushang.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseDao<UserEntity> {
    List<UserEntity> findByName(String name);
    List<UserEntity> findByLoginName(String loginName);
}
