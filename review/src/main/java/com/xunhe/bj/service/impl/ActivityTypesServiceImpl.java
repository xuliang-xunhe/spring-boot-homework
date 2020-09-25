package com.xunhe.bj.service.impl;

import com.xunhe.bj.mapper.ActivityTypesMapper;
import com.xunhe.bj.po.TblActiveTypes;
import com.xunhe.bj.service.ActiveTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityTypesServiceImpl implements ActiveTypesService {

    //通过mapper注入
    @Autowired
    private ActivityTypesMapper activityTypesMapper;
    @Override
    public List<TblActiveTypes> selectAll() {
        return activityTypesMapper.selectAll();
    }
}
