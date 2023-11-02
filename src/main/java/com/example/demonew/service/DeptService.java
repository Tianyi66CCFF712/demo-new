package com.example.demonew.service;


import com.example.demonew.entity.Dept;
import com.example.demonew.utils.PageBean;

import java.util.List;

public interface DeptService {
     PageBean list(Integer page, Integer pageSize, String name);
     void delete(List<Integer> ids);
     void insert(Dept dept);
     Dept search(Integer id);
     void update(Dept dept);
}
