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
public class Goods {

    @TableId(value = "goods_id", type = IdType.AUTO)
    private int goodsId;
    /* TODO 日期  date和Sting */
    private String date;
    private String goodsName;
    private String goodsColor;
    private String goodsType;
    private String goodsPosition;
    /* TODO 外键 warehouseWarehouseId */
    private int warehouseWarehouseId;
}
