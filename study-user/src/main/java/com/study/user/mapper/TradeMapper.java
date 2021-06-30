package com.study.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.user.pojo.vo.TradeVo;

import java.util.List;

/**
 * @author 刘祖鸿
 */
public interface TradeMapper extends BaseMapper<TradeVo> {

    /**
     * 返回行业树
     * @return TradeVo
     */
    List<TradeVo> queryTradeTree();
}
