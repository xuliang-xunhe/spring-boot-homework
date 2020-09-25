package com.xunhe.bj.service.impl;

import com.xunhe.bj.mapper.DepartmentMapper;
import com.xunhe.bj.po.TblDepartment;
import com.xunhe.bj.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    //通过mapper注入
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<TblDepartment> selectAll() {
        return departmentMapper.selectAll();
    }
}
