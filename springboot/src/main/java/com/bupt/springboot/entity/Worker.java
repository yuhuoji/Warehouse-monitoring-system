package com.bupt.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("worker")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @TableId(value = "worker_id", type = IdType.AUTO)
    private int workerId;
    private String workerName;
    private String password;
    private int warehouseWarehouseId;

}
