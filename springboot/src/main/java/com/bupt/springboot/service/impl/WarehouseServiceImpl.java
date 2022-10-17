package com.bupt.springboot.service.impl;

import com.bupt.springboot.entity.Goods;
import com.bupt.springboot.entity.Warehouse;
import com.bupt.springboot.entity.Worker;
import com.bupt.springboot.mapper.WarehouseMapper;
import com.bupt.springboot.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    /* Service层调用Mapper层 */
    private WarehouseMapper warehouseMapper;

    public int saveWarehouse(Warehouse warehouse) {
        Warehouse insertWarehouse = new Warehouse();
        /* id自增 */
        insertWarehouse.setWarehouseId(warehouse.getWarehouseId());
        insertWarehouse.setWarehouseName(warehouse.getWarehouseName());
        System.out.println("insertWarehouse = " + insertWarehouse);
        int insert = warehouseMapper.insert(insertWarehouse);
        System.out.println("insert = " + insert);
        return insert;
    }

    /* 展示所有warehouse */
    public List<Warehouse> displayWarehouse() {
        List<Warehouse> warehouses = warehouseMapper.selectList(null);
//        warehouses.forEach(System.out::println);
        return warehouses;
    }

    public List<?> displayGoodsAndWorkers(Warehouse warehouse) {
        System.out.println("displayGoodsAndWorkers warehouse" + warehouse);
        int id = warehouse.getWarehouseId();
        /* XXX 分别查两个表，整合返回 */
        List<Goods> goodsList = warehouseMapper.selectGoods(warehouse.getWarehouseId());
        List<Worker> workerList = warehouseMapper.selectWorkers(warehouse.getWarehouseId());
        List<List> warehouseContent = new ArrayList<List>();
        warehouseContent.add(0, goodsList);
        warehouseContent.add(1, workerList);
        return warehouseContent;
    }

}
