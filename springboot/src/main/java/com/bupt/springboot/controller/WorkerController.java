package com.bupt.springboot.controller;

import com.bupt.springboot.common.Result;
import com.bupt.springboot.entity.Worker;
import com.bupt.springboot.service.WorkerService;
import com.bupt.springboot.service.impl.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/worker")
public class WorkerController {
    /* TODO
     * Field injection is not recommended
     * Could not autowire. No beans of 'WorkerService' type found. */
    @Autowired(required = false)
    private WorkerService workerService;

    @Autowired
    private WorkerServiceImpl workerServiceImpl;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result<?> selectAllWorkers() {
        List<Worker> workerList = workerServiceImpl.selectAllWorkers();
        System.out.println("/worker/detail workerList = " + workerList);
        if (workerList.size() != 0) {
            return Result.success(workerList);
        } else {
            return Result.error("0", "No worker found.");
        }
    }

    /*插入工人*/
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result<?> saveWorker(@RequestBody Worker worker) {
        System.out.println("save worker_id = " + worker.getWorkerId() + ", worker_name = " + worker.getWorkerName() + ", warehouse_id = " + worker.getWarehouseId() + ", worker_password = " + worker.getWorkerPassword());
        System.out.println("workerService = " + workerService + ", workerServiceImpl = " + workerServiceImpl);
        int insert = workerServiceImpl.saveWorker(worker);
        if (insert == 1) {
            return Result.success(worker);
        } else {
            return Result.error("0", "Worker saved invalid");
        }
    }

    /* 删除工人 */
    @DeleteMapping("/{id}")
    public Result<?> updateWorkerById(@PathVariable Integer id) {
        System.out.println("@DeleteMapping deleteById, id= " + id + ",");
        int delete = workerServiceImpl.updateWorkerById(id);
        System.out.println("updateWorkerById delete = " + delete);
        if (delete != 0)
            return Result.success();
        else
            return Result.error("0", "Worker delete Error");
    }
}
