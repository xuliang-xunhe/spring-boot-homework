package com.xunhe.bj.mapper;

import com.xunhe.bj.po.TblDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface DepartmentMapper {
    //查询所有
    @Select("select * from department order by id")
    public List<TblDepartment> selectAll();
}
