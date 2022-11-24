package com.xiushang.jpa.repository;

import com.xiushang.entity.MarketingClientEntity;
import com.xiushang.entity.UserEntity;

import java.util.List;

public interface MarketingClientDao extends BaseDao<MarketingClientEntity> {

    List<MarketingClientEntity> findByUser(UserEntity userEntity);

    List<MarketingClientEntity> findByUserAndChannelAndAdvertiserId(UserEntity userEntity, String channel, String advertiserId);
}
