package com.gxtravel.service.impl;

import com.gxtravel.dao.UserMapper;
import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.User;
import com.gxtravel.service.UserService;
import com.gxtravel.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User confirmUser(User user){
        return userMapper.getUser(user);
    }

    public int userRegister(User user){
        return userMapper.userRegister(user);
    }

    public User showUserDetail(User user){
        return userMapper.getUser(user);
    }

    public int updateUserInfo(User user){
        return userMapper.updateUserInfo(user);
    }

    public int active(String activeCode){
        return userMapper.active(activeCode);
    }

    public int checkUsername(String username){
        return userMapper.checkUsername(username);
    }

    public Page<User> selectPageByQueryVo(QueryVo vo){
        Page<User> page = new Page<User>();
        //每页数
        page.setSize(5);
        vo.setSize(5);
        if (null != vo) {
            if(null != vo.getName() && !"".equals(vo.getName().trim())){
                vo.setName(vo.getName().trim());
            }
            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() -1)*vo.getSize());
            }
            //总条数
            page.setTotal(userMapper.customerCountByQueryVo(vo));
            page.setRows(userMapper.selectCustomerListByQueryVo(vo));
        }
        return page;
    }

    public void updateStateById(String id){
        userMapper.updateStateById(id);
    }

    @Override
    public void batchUser(List<User> list) {
        userMapper.batchUser(list);
    }

    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }
}