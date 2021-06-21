package com.study.minio.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.core.api.PageUtils;
import com.study.minio.feign.TestFeignClient;
import com.study.minio.pojo.dto.UserDto;
import com.study.minio.pojo.vo.UserVo;
import com.study.minio.service.TestFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 刘祖鸿
 */
@Service
@Slf4j
public class TestFeignServiceImpl implements TestFeignService {

    @Autowired
    private TestFeignClient testFeignClient;

    @Override
    public Object testFeign(Page page, UserDto userDto) {
        Object list = testFeignClient.queryUser(userDto);
//        if (CollectionUtils.isEmpty(list.getList())){
//            log.info("查询结果为空");
//            return null;
//        }
        return list;
    }
}
