package com.study.minio.feign;

import com.study.core.api.PageUtils;
import com.study.minio.pojo.dto.UserDto;
import com.study.minio.pojo.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author 刘祖鸿
 */
@FeignClient(value = "study-user",fallbackFactory = TestFeignClientFallback.class)
public interface TestFeignClient {


    /**
     * 测试Feign接口,调用study-user模块查询用户方法
     * @return  Uservo
     * @param userDto
     */
    @PostMapping(value = "/study-user/test/queryUser")
    Object queryUser(UserDto userDto);
}
