package com.xunhe.bj.service;

import com.xunhe.bj.po.TblUsers;
import com.xunhe.bj.po.TblUsersList;
import com.xunhe.bj.po.UsersListJK;
import java.util.List;

public interface UsersService {
    //增加
    public Integer addUsers(TblUsers tblUsers);

    //删除
    public Integer deleteUsers(String id);

    //修改
    public Integer updateUsers(TblUsers tblUsers);

    //密码检证
    public List<TblUsers> selectPS(TblUsers tblUsers);

    //用户查询
    public List<TblUsers> selecturs(TblUsers tblUsers);

    //按页数进行条件查询
    public List<TblUsersList> selecturList(UsersListJK tblUsers);

    //满足条件的所有数据件数
    public Integer selecturListcount(UsersListJK tblUsers);

    //查询所有
    public List<TblUsers> selectAll();
}