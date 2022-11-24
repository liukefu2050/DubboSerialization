package com.xiushang.admin.service.impl;


import com.xiushang.admin.service.MarketingDubboService;
import com.xiushang.admin.service.MarketingService;
import com.xiushang.entity.MarketingClientEntity;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@DubboService(filter = "userFilter",retries = 0)
public class MarketingDubboServiceImpl  implements MarketingDubboService, Serializable {

    @DubboReference(check = false)
    private MarketingService marketingService;

    @Transactional
    public List<MarketingClientEntity> getList() {

        List<MarketingClientEntity> list = marketingService.getList();
        if(list!=null){
            System.out.println(list.size());
        }

        return list;
    }

}
