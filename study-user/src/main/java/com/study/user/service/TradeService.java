package com.study.user.service;

import com.study.user.pojo.vo.TradeVo;

import java.util.List;
import java.util.Map;

/**
 * @author 刘祖鸿
 */
public interface TradeService {

    /**
     * 返回行业树
     * @return
     */
    List<Map<String,Object>> queryTradeTree() ;
}
