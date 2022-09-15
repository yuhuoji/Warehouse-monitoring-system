package com.bupt.springboot.service;

import com.bupt.springboot.entity.Worker;

public interface WorkerService {
     int saveWorker(Worker worker);

     public int deleteById(Integer id);
}
