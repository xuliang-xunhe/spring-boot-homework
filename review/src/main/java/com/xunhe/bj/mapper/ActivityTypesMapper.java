package com.xunhe.bj.mapper;

import com.xunhe.bj.po.TblActiveTypes;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface ActivityTypesMapper {
    //查询所有
    @Select("select * from activity_types order by id")
    public List<TblActiveTypes> selectAll();
}
