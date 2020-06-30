package com.gxtravel.dao;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.User;

import java.util.List;

public interface UserMapper {
    public User getUser(User user);

    public int userRegister(User user);

    public int updateUserInfo(User user);

    public int active(String activeCode);

    public int checkUsername(String username);

    //总条数
    public Integer customerCountByQueryVo(QueryVo vo);
    //结果集
    public List<User> selectCustomerListByQueryVo(QueryVo vo);

    int updateStateById(String id);

    void batchUser(List<User> list);
    //查询所有用户，什么条件也不带
    List<User> selectUserList();

    User selectUserById(Integer userid);
}
