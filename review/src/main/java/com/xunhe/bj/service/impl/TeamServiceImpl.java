package com.xunhe.bj.service.impl;

import com.xunhe.bj.mapper.TeamMapper;
import com.xunhe.bj.po.TblTeam;
import com.xunhe.bj.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    //通过mapper注入
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<TblTeam> selectAll() {
        return teamMapper.selectAll();
    }
}
