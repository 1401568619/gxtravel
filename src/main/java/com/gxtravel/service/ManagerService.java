package com.gxtravel.service;

import com.gxtravel.entity.Manager;

import java.util.List;
import java.util.Map;

public interface ManagerService {
    public int insertManager(Manager manager);

    public int deleteManager(String id);

    public List<Manager> getAllManager(String name);

    public Manager confirmManager(Manager manager);


}
