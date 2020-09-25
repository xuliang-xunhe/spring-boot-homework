package com.xunhe.bj.mapper;

import com.xunhe.bj.po.TblActicityTarget;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface ActicityTargetMapper {
    //查询所有
    @Select("select * from acticity_target order by id")
    public List<TblActicityTarget> selectAll();
}
