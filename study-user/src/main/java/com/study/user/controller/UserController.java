package com.study.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.core.api.PageUtils;
import com.study.user.pojo.dto.UserDto;
import com.study.user.pojo.vo.UserVo;
import com.study.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author 刘祖鸿
 */
@RestController
@Api(value = "测试增删改查",tags = "测试增删改查")
@RequestMapping("/test")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/queryUser")
    @ApiOperation(value = "查询用户", notes = "查询用户")
    public PageUtils<UserVo> queryUser (@RequestBody @Valid UserDto userDto){
        return userService.queryUser(new Page<>(userDto.getPage(),userDto.getLimit()),userDto);
    }

    @PostMapping("/exportUserExcel")
    @ApiOperation(value = "查询用户导出")
    public void exportUserExcel (HttpServletResponse response,UserDto userDto) throws IOException {
        userService.exportUserExcel(response,userDto);
    }

    @PostMapping("/insertUser")
    @ApiOperation(value = "批量新增用户", notes = "批量新增用户")
    public void insertUser (@RequestBody @Valid List<UserVo> userVoList){
        userService.insertUser(userVoList);
    }

    @PostMapping("/deleteUser")
    @ApiOperation(value = "批量删除用户", notes = "批量删除用户")
    public void deleteUser (@RequestBody @Valid List<UserVo> userVoList){
        userService.deleteUser(userVoList);
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "修改用户", notes = "修改用户")
    public void updateUser (@RequestBody UserVo userVo){
        userService.updateUser(userVo);
    }

}

