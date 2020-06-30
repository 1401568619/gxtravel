package com.gxtravel.service;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.User;
import com.gxtravel.utils.Page;

import java.util.List;

public interface UserService {
    public User confirmUser(User user);

    public int userRegister(User user);

    public User showUserDetail(User user);

    public int updateUserInfo(User user);

    public int active(String activeCode);

    public int checkUsername(String username);

    public Page<User> selectPageByQueryVo(QueryVo vo);

    public void updateStateById(String id);

    void batchUser(List<User> list);

    //查询所有用户，什么条件也不带
    List<User> selectUserList();
}
