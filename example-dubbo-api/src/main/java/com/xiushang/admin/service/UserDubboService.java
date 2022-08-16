package com.xiushang.admin.service;


import com.xiushang.framework.entity.vo.PageTableVO;

public interface UserDubboService {
    PageTableVO getList();

    void saveUser();
}
