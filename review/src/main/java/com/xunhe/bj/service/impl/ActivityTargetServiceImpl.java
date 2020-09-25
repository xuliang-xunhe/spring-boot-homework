package com.xunhe.bj.service.impl;

import com.xunhe.bj.mapper.ActicityTargetMapper;
import com.xunhe.bj.po.TblActicityTarget;
import com.xunhe.bj.service.ActicityTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityTargetServiceImpl implements ActicityTargetService {

    //通过mapper注入
    @Autowired
    private ActicityTargetMapper acticityTargetMapper;

    @Override
    public List<TblActicityTarget> selectAll() {
        return acticityTargetMapper.selectAll();
    }
}
