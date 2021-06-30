package com.study.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.user.mapper.TradeMapper;
import com.study.user.pojo.vo.TradeVo;
import com.study.user.service.TradeService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 刘祖鸿
 */
@Service
public class TradeServiceImpl extends ServiceImpl<TradeMapper, TradeVo> implements TradeService {


    @Override
    public List<Map<String,Object>> queryTradeTree() {
        List<TradeVo> list = baseMapper.queryTradeTree();

        if (CollectionUtils.isEmpty(list)){
            return null;
        }

        // 过滤空对象
        List<Map<String,Object>> result = new ArrayList<>();

        list.stream().filter(r -> r != null).forEach(r -> {
            if ("0".equals(r.getPtRadeNo())){
                Map<String,Object> map = new HashMap<>();
                List<Map<String,Object>> children = new ArrayList<>();
                list.stream().forEach(r1 -> {
                    if (r.getTradeNo().equals(r1.getPtRadeNo())){
                        Map<String,Object> map1 = new HashMap<>();
                        List<Map<String,Object>> children1 = new ArrayList<>();
                        list.stream().forEach(r2 ->{
                            if (r1.getTradeNo().equals(r2.getPtRadeNo())){
                                Map<String,Object> map2 = new HashMap<>();
                                List<Map<String,Object>> children2 = new ArrayList<>();
                                map2.put("tradeNo",r2.getTradeNo());
                                map2.put("tradeName",r2.getTradeName());
                                children1.add(map2);
                            }
                        });
                        map1.put("tradeNo",r1.getTradeNo());
                        map1.put("tradeName",r1.getTradeName());
                        map1.put("children",children1);
                        children.add(map1);
                    }
                });
                map.put("tradeNo",r.getTradeNo());
                map.put("tradeName",r.getTradeName());
                map.put("children",children);
                result.add(map);
            }
        });

        return result;

    }



}
