package com.study.minio.pojo.dto;

import com.study.core.api.BasePage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 刘祖鸿
 */
@ApiModel(value = "查询用户入参",description = "查询用户入参")
@Data
public class UserDto extends BasePage implements Serializable {

    @ApiModelProperty(value = "用户名")
    private String userName;

}
