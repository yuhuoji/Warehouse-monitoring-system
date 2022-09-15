package com.bupt.springboot.controller;

import com.bupt.springboot.common.Result;
import com.bupt.springboot.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bupt.springboot.entity.Warehouse;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    /* Controller层调用Service层 */
    private WarehouseService warehouseService;

    /* 插入仓库，保存仓库名称 */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result<?> saveWarehouse(@RequestBody Warehouse warehouse) {
        System.out.println("save warehouse_id = " + warehouse.getWarehouseId() + ", warehouse_name = " + warehouse.getWarehouseName() + " ");
        int insert = warehouseService.saveWarehouse(warehouse);
        if (insert == 1) {
            return Result.success();
        } else {
            return Result.error("0", "Save error.(PostMapping)");
        }
    }

    /* 显示每个仓库id和仓库名 GET方法, 返回List给前台展示  */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public List<Warehouse> displayWarehouse() {
//        System.out.println("check warehouse_id = " + warehouse.getWarehouseId() + ", warehouse_name = " + warehouse.getWarehouseName() + " ");
        List<Warehouse> warehouses = warehouseService.displayWarehouse();
        return warehouses;
    }


    /* 显示某个仓库的货物状态（如货物位置）和信息（如货物种类）和每个仓库的worker，返回List<List>, goodsList workerList */
    /* TODO List<List> 和 List<?>*/
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public List<?> displayGoodsAndWorkers(@RequestBody Warehouse warehouse) {
        //用warehouse_id查询
        System.out.println("displayGoodsAndWorkers " + warehouse);
        List<?> warehouseContent = warehouseService.displayGoodsAndWorkers(warehouse);
        return warehouseContent;
    }


}
