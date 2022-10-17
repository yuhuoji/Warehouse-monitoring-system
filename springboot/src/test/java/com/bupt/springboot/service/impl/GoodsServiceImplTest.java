package com.bupt.springboot.service.impl;

import com.bupt.springboot.entity.Goods;
import com.bupt.springboot.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GoodsServiceImplTest {
    @Autowired
    private GoodsMapper goodsMapper;

//    @Test
    void selectAllGoods() {
    }
//    @Test
    void goodsStatisticsByColor() {
        List<Goods> goodsList = goodsMapper.selectAllGoods();
        System.out.println("goodsList = " + goodsList.toString());
        Map<String, Long> goodsColorMap = new HashMap<>();
        goodsColorMap.put("red", goodsList.stream().filter(goods -> goods.getGoodsColor().equals("red")).count());
        goodsColorMap.put("blue", goodsList.stream().filter(goods -> goods.getGoodsColor().equals("blue")).count());
        goodsColorMap.put("yellow", goodsList.stream().filter(goods -> goods.getGoodsColor().equals("yellow")).count());
        goodsColorMap.put("green", goodsList.stream().filter(goods -> goods.getGoodsColor().equals("green")).count());
        System.out.println("goodsColorMap = " + goodsColorMap);
    }
}