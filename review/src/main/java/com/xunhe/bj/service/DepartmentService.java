package com.xunhe.bj.service;

import com.xunhe.bj.po.TblDepartment;
import java.util.List;

public interface DepartmentService {
    //查询所有
    public List<TblDepartment> selectAll();
}