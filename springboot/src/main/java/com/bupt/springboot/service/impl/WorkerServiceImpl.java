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
    private WorkerMapper workerMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    public List<Worker> selectAllWorkers() {
        return workerMapper.selectAllWorkers();
    }

    /* FIXME woker外键约束， id自增 */
    public int saveWorker(Worker worker) {
        int insert = 1;
        /* worker_id is already in worker table */
        List<Integer> workerIdList = workerMapper.selectAllWorkerId();
        if (workerIdList.contains(worker.getWorkerId())){
            return 0;
        }
        /* warehouse_id is not in warehouse table */
        List<Integer> warehouseIdList = warehouseMapper.selectAllWarehouseId();
        if (!warehouseIdList.contains(worker.getWarehouseId())) {
            return 0;
        }
        System.out.println("worker.getWarehouseId() = " + worker.getWarehouseId() + " is in warehouseIdList.");
        Worker insertWorker = new Worker();
        insertWorker.setWorkerId(worker.getWorkerId());
        insertWorker.setWorkerName(worker.getWorkerName());
        insertWorker.setWorkerPassword(worker.getWorkerPassword());
        insertWorker.setWarehouseId(worker.getWarehouseId());
        System.out.println("insertWorker = " + insertWorker);
        insert = workerMapper.insert(insertWorker);
        System.out.println("worker = " + worker.toString() + "insert = " + insert + ", insert success");
        return insert;
    }

    public int updateWorkerById(Integer id) {
        int delete = workerMapper.deleteById(id);
        System.out.println("delete = " + delete);
        return delete;
    }

}
