package com.xunhe.bj.mapper;

import com.xunhe.bj.po.TblTeam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface TeamMapper {
    //查询所有
    @Select("select * from team order by id")
    public List<TblTeam> selectAll();
}
