package com.xiushang.admin.controller;

import com.xiushang.admin.service.OrderPayDubboService;
import com.xiushang.framework.entity.vo.PageTableVO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/user")
public class ConsumerController {
    @DubboReference
    OrderPayDubboService orderPayDubboService;

    @GetMapping("list")
    public PageTableVO getList() {

        PageTableVO object = orderPayDubboService.getList();

        return object;
    }


}
