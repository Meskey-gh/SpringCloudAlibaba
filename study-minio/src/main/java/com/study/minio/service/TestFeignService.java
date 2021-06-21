package com.study.minio.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.core.api.PageUtils;
import com.study.minio.pojo.dto.UserDto;
import com.study.minio.pojo.vo.UserVo;

/**
 * @author 刘祖鸿
 */
public interface TestFeignService {
    /**
     * 测试feign调用
     * @return UserVo
     * @param Page
     * @param userDto
     */
    Object testFeign(Page Page, UserDto userDto);

}
