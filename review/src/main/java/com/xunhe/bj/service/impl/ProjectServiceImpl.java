package com.xunhe.bj.service.impl;

import com.xunhe.bj.mapper.ProjectMapper;
import com.xunhe.bj.po.TblProject;
import com.xunhe.bj.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    //通过mapper注入
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<TblProject> selectAll() {
        return projectMapper.selectAll();
    }
}
