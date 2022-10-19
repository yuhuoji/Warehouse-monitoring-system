package com.bupt.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.springboot.common.Result;
import com.bupt.springboot.entity.Goods;
import com.bupt.springboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 分页查询
     *
     * @param pageNum  当前页
     * @param pageSize 当前每页大小
     * @param search   搜索内容
     * @return Result
     */
    @RequestMapping(value = "/findPage", method = RequestMethod.GET)
    public Result<?> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String search) {
//        goodsService.
        if (true) {
            return Result.success();
        } else {
            return Result.error("0", "Search error.");
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
