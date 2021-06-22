package com.study.user.pojo.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 刘祖鸿
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "查询用户返回参数",description = "查询用户返回参数")
public class UserVo implements Serializable{

    @ApiModelProperty(value = "用户名")
    @ExcelProperty(value = {"用户名"}, index = 0)
    private String userName;

    @ApiModelProperty(value = "年龄")
    @ExcelProperty(value = {"年龄"}, index = 1)
    private int userAge;

    @ApiModelProperty(value = "性别")
    @ExcelProperty(value = {"性别"}, index = 2)
    private String userSex;

    @ApiModelProperty(value = "住址")
    @ExcelProperty(value = {"住址"}, index = 3)
    private String userAddr;

    @ApiModelProperty(value = "手机号")
    @ExcelProperty(value = {"手机号"}, index = 4)
    private String userMobile;

    @ApiModelProperty(value = "修改用户名")
    @ExcelIgnore
    private String updateName;
}
