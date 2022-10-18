package com.bupt.springboot.service;

import com.bupt.springboot.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    int saveWarehouse(Warehouse warehouse);

    List<Warehouse> selectAllWarehouses();

    List<?> displayGoodsAndWorkers(Warehouse warehouse);
}
