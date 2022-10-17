package com.bupt.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.springboot.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("select * from goods")
    List<Goods> selectAllGoods();
}
