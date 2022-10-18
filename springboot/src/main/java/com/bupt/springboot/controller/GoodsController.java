package com.bupt.springboot.controller;

import com.bupt.springboot.common.Result;
import com.bupt.springboot.entity.Goods;
import com.bupt.springboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /* 返回所有的goods */
    @RequestMapping(value = "/selectAllGoods", method = RequestMethod.GET)
    public Result<?> selectAllGoods() {
        System.out.println("selectAllGoods");
        List<Goods> goodsList = goodsService.selectAllGoods();
        if (goodsList != null) {
            return Result.success(goodsList);
        } else {
            return Result.error("0", "No data was queried");
        }
    }

    /* 返回goods四种颜色的统计结果 */
    @RequestMapping(value = "/goodsStatisticsByType", method = RequestMethod.GET)
    public Result<?> goodsStatisticsByType() {
        Map<String, Long> goodsTypeMap = goodsService.goodsStatisticsByType();
        if (goodsTypeMap.get("red") + goodsTypeMap.get("blue") + goodsTypeMap.get("green") + goodsTypeMap.get("yellow") != 0) {
            return Result.success(goodsTypeMap);
        } else {
            return Result.error("0", "No data was queried");
        }
    }

}
