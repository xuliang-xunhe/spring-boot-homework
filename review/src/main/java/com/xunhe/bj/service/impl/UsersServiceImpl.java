package com.xunhe.bj.service.impl;

import com.xunhe.bj.mapper.UsersMapper;
import com.xunhe.bj.po.TblUsers;
import com.xunhe.bj.po.TblUsersList;
import com.xunhe.bj.po.UsersListJK;
import com.xunhe.bj.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    //通过mapper注入
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Integer addUsers(TblUsers tblUsers) {
        return usersMapper.addUsers(tblUsers);
    }

    @Override
    public Integer deleteUsers(String id) {
        return usersMapper.deleteUsers(id);
    }

    @Override
    public Integer updateUsers(TblUsers tblUsers) {
        return usersMapper.updateUsers(tblUsers);
    }

    @Override
    public List<TblUsers> selectPS(TblUsers tblUsers) {
        return usersMapper.selectPS(tblUsers);
    }

    @Override
    public List<TblUsers> selecturs(TblUsers tblUsers) {
        return usersMapper.selecturs(tblUsers);
    }

    @Override
    public List<TblUsersList> selecturList(UsersListJK tblUsers) {
        return usersMapper.selecturList(tblUsers);
    }

    @Override
    public Integer selecturListcount(UsersListJK tblUsers) {
        return usersMapper.selecturListcount(tblUsers);
    }

    @Override
    public List<TblUsers> selectAll() {
        return usersMapper.selectAll();
    }
}
