package com.xunhe.bj.mapper;

import com.xunhe.bj.po.TblActicityTarget;
import com.xunhe.bj.po.TblProject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface ProjectMapper {
    //查询所有
    @Select("select * from project order by id")
    public List<TblProject> selectAll();
}
