package com.study.user.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.core.api.ExcelUtils;
import com.study.core.api.PageUtils;
import com.study.user.mapper.UserMapper;
import com.study.user.pojo.dto.UserDto;
import com.study.user.pojo.vo.UserVo;
import com.study.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @Override
    public void exportUserExcel(HttpServletResponse response, UserDto userDto) throws IOException {
        List<UserVo> list = baseMapper.queryUser(new Page<>(userDto.getPage(),userDto.getLimit()),userDto);
        if (CollectionUtils.isEmpty(list)){
            log.info("查询结果为空");
            return ;
        }
        String fileName = "测试导出";
        String sheetName = "第一个Sheet";
        ExcelUtils.excelExport(response,new UserVo(),list,fileName,sheetName);

    }
}
