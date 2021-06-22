package com.study.user.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.core.api.ExcelUtils;
import com.study.user.Listener.ExcelHandleListener;
import com.study.user.mapper.ExcelHandleMapper;
import com.study.user.mapper.UserMapper;
import com.study.user.pojo.dto.UserDto;
import com.study.user.pojo.vo.UserVo;
import com.study.user.service.ExcelHandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 刘祖鸿
 */
@Service
@Slf4j
public class ExcelHandleServiceImpl extends ServiceImpl<UserMapper, UserVo> implements ExcelHandleService {



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

    /**
     * TODO
     * @param file
     * @throws IOException
     */
    @Override
    public void importExcel(MultipartFile file) throws IOException {
        List<UserVo> userVoList = EasyExcel.read(file.getInputStream())
                // 注册监听器，可以在这里校验字段
                .registerReadListener(new ExcelHandleListener())
                .head(UserVo.class)
                // 设置sheet，默认读取第一个
                .sheet()
                // 设置标题所在行数
                .headRowNumber(1)
                .doReadSync();
        if (CollectionUtils.isEmpty(userVoList)){
            return;
        }

        baseMapper.deleteUser(userVoList);
        baseMapper.insertUser(userVoList);

    }
}
