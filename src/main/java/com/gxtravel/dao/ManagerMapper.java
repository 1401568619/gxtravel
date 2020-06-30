package com.gxtravel.dao;

import com.gxtravel.entity.Manager;

import java.util.List;

public interface ManagerMapper {
    public int insertManager(Manager manager);

    public int deleteManager(String id);

    public List<Manager> getAllManager(String name);

    public Manager confirmManager(Manager manager);
}
