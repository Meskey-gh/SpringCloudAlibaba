package com.study.core.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘祖鸿
 */
@ApiModel(description = "接口返回业务对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    @ApiModelProperty(value = "接口返回业务标识",required = true)
    private boolean success;

    private String code;


}
