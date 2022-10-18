package com.bupt.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.springboot.entity.Goods;
import com.bupt.springboot.entity.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("select * from goods")
    List<Goods> selectAllGoods();

    @Select("select * from goods where warehouse_id = #{id}")
    List<Goods> selectAllGoodsInWarehouse(int id);
}
