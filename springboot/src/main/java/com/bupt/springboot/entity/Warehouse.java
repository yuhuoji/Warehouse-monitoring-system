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

/* @Deprecated
* *//* goods的类型，将goods放入warehouse *//*
    private int goodsId;
    *//* 日期date类型 *//*
    private String date;
    private String goodsName;
    private String goodsColor;
    private String goodsType;
    private String goodsPosition;
    *//* 外键 warehouseWarehouseId *//*
    private int warehouseWarehouseId;*/

}
