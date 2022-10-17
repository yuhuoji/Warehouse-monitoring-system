package com.bupt.springboot.service;

import com.bupt.springboot.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> selectAllGoods();

    public Map<String, Long> goodsStatisticsByColor();
}
