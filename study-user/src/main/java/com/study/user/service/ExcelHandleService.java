package com.study.user.service;


import com.study.user.pojo.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘祖鸿
 */
public interface ExcelHandleService {

    /**
     * 导出查询用户信息
     * @param response
     * @param userDto
     * @return
     */
    void exportUserExcel(HttpServletResponse response, UserDto userDto) throws IOException;

    /**
     * 导入excel解析入库
     * @param file
     */
    void importExcel(MultipartFile file) throws IOException;
}
