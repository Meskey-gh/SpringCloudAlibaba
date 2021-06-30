package com.study.user.controller;

import com.study.user.pojo.vo.TradeVo;
import com.study.user.service.TradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 刘祖鸿
 */
@RestController
@RequestMapping("/returnTree")
@Api(value = "返回树形结构",tags = "返回树形结构")
public class TradeController {

    @Autowired
    private TradeService tradeService;


    @PostMapping("/tradeTree")
    @ApiOperation(value = "返回行业树",notes = "返行业树")
    public List<Map<String,Object>> queryTradeTree(){
        return tradeService.queryTradeTree();
    }


}
