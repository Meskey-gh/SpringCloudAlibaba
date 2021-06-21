package com.study.minio.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.core.api.PageUtils;
import com.study.minio.pojo.dto.UserDto;
import com.study.minio.service.TestFeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘祖鸿
 */
@RestController
@RequestMapping("/testFeign")
@Api(value = "测试feign调用其他模块", tags = "测试feign调用其他模块")
public class TestFeignController {

    @Autowired
    TestFeignService testFeignService;

    @PostMapping("/testFeign")
    @ApiOperation(value = "测试feign调用其他模块",notes = "测试feign调用其他模块")
    public Object testFeign(UserDto userDto){
        return testFeignService.testFeign(new Page<>(userDto.getPage(),userDto.getLimit()),userDto);
    }




}
