package com.bupt.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.springboot.entity.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository /*  */
public interface WorkerMapper extends BaseMapper<Worker> {

}
