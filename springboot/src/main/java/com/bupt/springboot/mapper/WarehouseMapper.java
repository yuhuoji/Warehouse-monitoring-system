package com.bupt.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.springboot.entity.Goods;
import com.bupt.springboot.entity.Worker;
import com.bupt.springboot.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse> {

    /* select workers */
    @Select("select * from worker where warehouse_warehouse_id = #{id}")
    List<Worker> selectWorkers(int id);

    /* 用于插入新的工人用， 检验输入的仓库id是否真的存在 */
    @Select("select warehouse_id from warehouse")
    List<Integer> selectAllWarehouseId();

    /* select goods */
    @Select("select * from goods where warehouse_warehouse_id = #{id}")
    List<Goods> selectGoods(int id);

}
