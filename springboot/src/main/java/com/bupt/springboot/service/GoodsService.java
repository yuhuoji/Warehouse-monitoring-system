package com.bupt.springboot.service;

import com.bupt.springboot.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> selectAllGoods();

    Map<String, Long> goodsStatisticsByType();
}
