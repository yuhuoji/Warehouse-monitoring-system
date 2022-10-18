package com.bupt.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("warehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    @TableId(value = "goods_id", type = IdType.AUTO)
    private int goodsId;
    /* TODO 日期  date和Sting */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm:ss", timezone = "GMT+8")
    private Date date;
//    private String goodsName;
//    private String goodsColor;
    private String goodsType; //商品颜色
    private String goodsPosition;
    /* TODO 外键 warehouseId 删除or添加 */
    private int warehouseId;
}
