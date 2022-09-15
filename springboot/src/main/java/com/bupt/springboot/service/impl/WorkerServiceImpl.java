package com.bupt.springboot.service.impl;

import com.bupt.springboot.entity.Worker;

import com.bupt.springboot.mapper.WarehouseMapper;
import com.bupt.springboot.mapper.WorkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl {

    @Autowired
    /* Service层调用Mapper层 */
    private WorkerMapper workerMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    /* TODO 需要输入的warehouseWarehouseId是否在warehouse表中存在 */
    public int saveWorker(Worker worker){
        /* 先进行判断 */
        /* TODO 所有已存在的warehouseId,调用warehouse的mapper？？？ */
        List<Integer> warehouseIdList = warehouseMapper.selectAllWarehouseId();
        int id = worker.getWarehouseWarehouseId();
        System.out.println("worker.getWarehouseWarehouseId()" + worker.getWarehouseWarehouseId());
        int insert = 1;
        if(warehouseIdList.contains(id)) {
            /* 查询外键约束存在，可以插入 */
            Worker insertWorker = new Worker();
            /* TODO id自增 */
            insertWorker.setWorkerId(worker.getWorkerId());
            insertWorker.setWorkerName(worker.getWorkerName());
//            /* TODO 工人密码不应由管理员设置 */
//            insertWorker.setPassword("1234");
            insertWorker.setWarehouseWarehouseId(worker.getWarehouseWarehouseId());
            System.out.println("insertWarehouse = " + insertWorker);
            insert = workerMapper.insert(insertWorker);
            System.out.println("insert = " + insert);
        }else {
            insert = 0;
        }
        return insert;
    }


    public int deleteById(Integer id) {
        int delete = workerMapper.deleteById(id);
        System.out.println("delete = " + delete);
        return delete;
    }

}
