package com.example.demonew.service;

import com.example.demonew.entity.Emp;
import com.example.demonew.utils.PageBean;

import java.util.List;


public interface EmpService {


    PageBean page(Integer page, Integer pageSize, String name);
    void delete(List<Integer> ids);


    void add(Emp emp);

    void updata(Emp emp);

    Emp search(Integer id);


}
