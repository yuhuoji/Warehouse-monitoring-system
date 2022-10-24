package com.bupt.springboot.service;

import com.bupt.springboot.entity.Worker;

import java.util.List;

public interface WorkerService {
     int saveWorker(Worker worker);

     int updateWorkerById(Integer id);

     List<Worker> selectAllWorkers();
}
