package com.bupt.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("warehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    @TableId(value = "warehouse_id", type = IdType.AUTO)
    private Integer warehouseId;
    private String warehouseName;
}
