package com.study.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.core.api.PageUtils;
import com.study.user.pojo.dto.UserDto;
import com.study.user.pojo.vo.UserVo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 刘祖鸿
 */
public interface UserService {

    /**
     * 用户查询
     * @param page
     * @param userDto
     * @return
     */
    PageUtils<UserVo> queryUser(Page page, UserDto userDto);

    /**
     * 新增用户
     * @param userVoList
     */
    void insertUser(List<UserVo> userVoList);

    /**
     * 删除用户
     * @param userVoList
     */
    void deleteUser(List<UserVo> userVoList);

    /**
     * 修改用户
     * @param userVo
     */
    void updateUser(UserVo userVo);


}
