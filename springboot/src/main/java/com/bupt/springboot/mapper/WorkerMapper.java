package com.bupt.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.springboot.entity.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorkerMapper extends BaseMapper<Worker> {

    @Select("select * from worker")
    List<Worker> selectAllWorkers();

    @Select("select * from worker where warehouse_id = #{id}")
    List<Worker> selectAllWorkersInWarehouse(int id);
}
