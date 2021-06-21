package com.study.minio.pojo.vo;

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
    private String userName;

    @ApiModelProperty(value = "年龄")
    private int userAge;

    @ApiModelProperty(value = "性别")
    private String userSex;

    @ApiModelProperty(value = "住址")
    private String userAddr;

    @ApiModelProperty(value = "手机号")
    private String userMobile;

    @ApiModelProperty(value = "修改用户名")
    private String updateName;
}
