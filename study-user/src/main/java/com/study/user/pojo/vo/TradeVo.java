package com.study.user.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 刘祖鸿
 */
@ApiModel(value = "行业树返回实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeVo {

    @ApiModelProperty("行业编号")
    private String tradeNo;

    @ApiModelProperty("上级行业编号")
    private String ptRadeNo;


    @ApiModelProperty("行业名称")
    private String tradeName;

    @ApiModelProperty("下级行业集合")
    private List<TradeVo> list;



}
