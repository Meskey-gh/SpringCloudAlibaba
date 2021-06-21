package com.study.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.user.pojo.dto.UserDto;
import com.study.user.pojo.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘祖鸿
 */
public interface UserMapper  extends BaseMapper<UserVo> {

    /**
     * 用户查询
     *
     * @param page
     * @param userDto
     * @return com.study.user.pojo.vo.UserVo
     */
    List<UserVo> queryUser(Page page, @Param("param") UserDto userDto);

    /**
     * 新增用户
     *
     * @param userVoList
     */
    void insertUser(@Param("param")List<UserVo> userVoList);

    /**
     * 删除用户
     *
     * @param userVoList
     */
    void deleteUser(@Param("param")List<UserVo> userVoList);

    /**
     *修改用户
     *
     * @param userVo
     */
    void updateUser(@Param("param") UserVo userVo);

    List<UserVo> queryUser2(@Param("param") UserDto userDto);
}
