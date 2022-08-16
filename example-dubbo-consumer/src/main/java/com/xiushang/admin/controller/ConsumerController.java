package com.xiushang.admin.controller;

import com.alibaba.fastjson.JSON;
import com.xiushang.admin.service.UserDubboService;
import com.xiushang.common.utils.LazyLoadFilter;
import com.xiushang.framework.entity.vo.PageTableVO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/test")
public class ConsumerController {
    @DubboReference(check = false)
    private UserDubboService userDubboService;

    @ResponseBody
    @GetMapping("list")
    public String getList() {

        try {
            PageTableVO object = userDubboService.getList();
            String string = JSON.toJSONString(object, new LazyLoadFilter());

            return string;
        }catch (Exception e){
            e.printStackTrace();
            return e.getStackTrace().toString();
        }
    }

    @ResponseBody
    @GetMapping("post")
    public String post() {

         userDubboService.saveUser();

        return "0";
    }

}
