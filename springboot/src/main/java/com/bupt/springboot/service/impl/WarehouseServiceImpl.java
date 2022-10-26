package com.bupt.springboot.service.impl;

import com.bupt.springboot.entity.Goods;
import com.bupt.springboot.entity.Warehouse;
import com.bupt.springboot.entity.Worker;
import com.bupt.springboot.mapper.GoodsMapper;
import com.bupt.springboot.mapper.WarehouseMapper;
import com.bupt.springboot.mapper.WorkerMapper;
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

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private WorkerMapper workerMapper;

    public int saveWarehouse(Warehouse warehouse) {
        Warehouse insertWarehouse = new Warehouse();
        List<Integer> warehouseIdList = warehouseMapper.selectAllWarehouseId();
        if (warehouseIdList.contains(warehouse.getWarehouseId())){
            return 0;
        }
        insertWarehouse.setWarehouseId(warehouse.getWarehouseId());
        insertWarehouse.setWarehouseName(warehouse.getWarehouseName());
        System.out.println("insertWarehouse = " + insertWarehouse);
        int insert = warehouseMapper.insert(insertWarehouse); //success 1, failure 0
        System.out.println("warehouse insert = " + insert);
        return insert;
    }

    /* 展示所有warehouse */
    public List<Warehouse> selectAllWarehouses() {
        List<Warehouse> warehouses = warehouseMapper.selectList(null);
        return warehouses;
    }

    public List<?> displayGoodsAndWorkers(Warehouse warehouse) {
//        System.out.println("displayGoodsAndWorkers warehouse" + warehouse);
        int id = warehouse.getWarehouseId();
        /* XXX 分别查两个表，整合返回 */
        List<Goods> goodsList = goodsMapper.selectAllGoodsInWarehouse(warehouse.getWarehouseId());
        List<Worker> workerList = workerMapper.selectAllWorkersInWarehouse(warehouse.getWarehouseId());
        List<List> warehouseContent = new ArrayList<>();
        warehouseContent.add(0, goodsList);
        warehouseContent.add(1, workerList);
        return warehouseContent;
    }

}
