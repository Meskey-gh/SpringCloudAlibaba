package com.study.user.controller;

import com.study.user.pojo.dto.UserDto;
import com.study.user.service.ExcelHandleService;
import com.study.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘祖鸿
 */
@RestController
@RequestMapping("/excelHandle")
@Api(value = "Excel导入导出功能", tags = "Excel导入导出功能")
public class ExcelHandleController {

    @Autowired
    private ExcelHandleService excelHandleService;


    @PostMapping("/exportExcel")
    @ApiOperation(value = "Excel导出",notes = "Excel导出")
    public void exportUserExcel (HttpServletResponse response, UserDto userDto) throws IOException {
        excelHandleService.exportUserExcel(response,userDto);
    }


    @PostMapping("/importExcel")
    @ApiOperation(value = "Excel导入",notes = "Excel导入")
    public void exportUserExcel (@RequestBody MultipartFile file) throws IOException {
        excelHandleService.importExcel(file);

    }


}
