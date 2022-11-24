package com.xiushang.admin.controller;

import com.alibaba.fastjson.JSON;
import com.xiushang.admin.service.MarketingDubboService;
import com.xiushang.admin.service.MarketingService;
import com.xiushang.common.utils.LazyLoadFilter;
import com.xiushang.entity.MarketingClientEntity;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
@RequestMapping("/test")
public class ConsumerController {
    @DubboReference(check = false)
    private MarketingDubboService userDubboService;

    @DubboReference(check = false)
    private MarketingService userService;

    @ResponseBody
    @GetMapping("list1")
    public String getListOne() {

        try {
            List<MarketingClientEntity> list = userService.getList();
            String string = JSON.toJSONString(list, new LazyLoadFilter());

            return string;
        }catch (Exception e){
            e.printStackTrace();
            return e.getStackTrace().toString();
        }
    }

    @ResponseBody
    @GetMapping("list2")
    public String getList() {

        try {
            List<MarketingClientEntity> list = userDubboService.getList();
            String string = JSON.toJSONString(list, new LazyLoadFilter());

            return string;
        }catch (Exception e){
            e.printStackTrace();
            return e.getStackTrace().toString();
        }
    }

}
