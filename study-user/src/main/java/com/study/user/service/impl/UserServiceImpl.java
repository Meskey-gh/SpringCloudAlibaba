package com.study.user.service.impl;

import cn.humingfeng.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.core.api.PageUtils;
import com.study.user.mapper.UserMapper;
import com.study.user.pojo.dto.UserDto;
import com.study.user.pojo.vo.UserVo;
import com.study.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 刘祖鸿
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserVo> implements UserService {

    // @DS注解切换数据源，默认主数据源master，@DS("slave")切换从数据源，加载实现类上


    @Override
    @DS("slave")
    public PageUtils<UserVo> queryUser(Page page, UserDto userDto) {
        List<UserVo> list = baseMapper.queryUser(page,userDto);
        if (CollectionUtils.isEmpty(list)){
            log.info("查询结果为空");
            return null;
        }
        return new PageUtils<>(page.setRecords(list)) ;
    }

    @Override
    public void insertUser(List<UserVo> userVoList) {
        baseMapper.insertUser(userVoList);
    }

    @Override
    public void deleteUser(List<UserVo> userVoList) {
        baseMapper.deleteUser(userVoList);
    }

    @Override
    public void updateUser(UserVo userVo) {
        baseMapper.updateUser(userVo);

    }

}
