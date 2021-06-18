package com.study.user.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 刘祖鸿
 */
@Data
@ApiModel(value = "批量新增/删除用户入参",description = "批量新增/删除用户入参")
public class AddUserDto implements Serializable {

    @ApiModelProperty(value = "用户信息集合")
    List<String> userVoList;
}