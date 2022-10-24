package com.bupt.springboot.service.impl;

import com.bupt.springboot.common.Result;
import com.bupt.springboot.entity.Goods;
import com.bupt.springboot.mapper.GoodsMapper;
import com.bupt.springboot.service.GoodsService;
import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> selectAllGoods() {
        List<Goods> goodsList = goodsMapper.selectAllGoods();
//        goodsList.forEach(System.out::println);
        return goodsList;
    }

    /* 按四种颜色统计仓库里所有的goods，返回Map(key,value)
     * red blue yellow green
     */
    public Map<String, Long> goodsStatisticsByType() {
        List<Goods> goodsList = goodsMapper.selectAllGoods();
//        System.out.println("goodsStatisticsByType goodsList = " + goodsList.toString());
        Map<String, Long> goodsTypeMap = new HashMap<>();
        goodsTypeMap.put("red", goodsList.stream().filter(goods -> goods.getGoodsType().equals("red")).count());
        goodsTypeMap.put("blue", goodsList.stream().filter(goods -> goods.getGoodsType().equals("blue")).count());
        goodsTypeMap.put("yellow", goodsList.stream().filter(goods -> goods.getGoodsType().equals("yellow")).count());
        goodsTypeMap.put("green", goodsList.stream().filter(goods -> goods.getGoodsType().equals("green")).count());
        System.out.println("GoodsTypeMap = " + goodsTypeMap);
        return goodsTypeMap;
    }
}
