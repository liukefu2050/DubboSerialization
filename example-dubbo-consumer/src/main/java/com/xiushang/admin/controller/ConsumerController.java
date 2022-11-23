package com.xiushang.admin.controller;

import com.alibaba.fastjson.JSON;
import com.xiushang.admin.service.UserDubboService;
import com.xiushang.common.user.vo.UserVo;
import com.xiushang.common.utils.LazyLoadFilter;
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
    private UserDubboService userDubboService;

    @ResponseBody
    @GetMapping("list")
    public String getList() {

        try {
            List<UserVo> list = userDubboService.getList();
            String string = JSON.toJSONString(list, new LazyLoadFilter());

            return string;
        }catch (Exception e){
            e.printStackTrace();
            return e.getStackTrace().toString();
        }
    }

}
