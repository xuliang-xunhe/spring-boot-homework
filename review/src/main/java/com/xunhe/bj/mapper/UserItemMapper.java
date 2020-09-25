package com.xunhe.bj.mapper;

import com.xunhe.bj.po.TblTeam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface UserItemMapper {
    //查询所有
    @Select("select * from acticity_target;" +
            "select * from activity_types;" +
            "select * from department;" +
            "select * from project;" +
            "select * from team")
    public List<TblTeam> selectAll();
}
