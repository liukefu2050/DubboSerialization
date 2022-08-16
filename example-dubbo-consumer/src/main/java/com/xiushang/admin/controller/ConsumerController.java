package com.xiushang.admin.controller;

import com.xiushang.admin.service.UserDubboService;
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
    UserDubboService userDubboService;

    @ResponseBody
    @GetMapping("list")
    public PageTableVO getList() {

        PageTableVO object = userDubboService.getList();

        return object;
    }

    @ResponseBody
    @GetMapping("post")
    public String post() {

         userDubboService.saveUser();

        return "0";
    }

}
