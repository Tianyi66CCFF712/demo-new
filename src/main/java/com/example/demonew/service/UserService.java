package com.example.demonew.service;

import com.example.demonew.utils.PageBean;
import com.example.demonew.utils.Result;
import com.example.demonew.entity.User;

import java.time.LocalDate;
import java.util.List;


public interface UserService {


    PageBean page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    void delete(List<Integer> ids);


    Result add(User user);

    void updata(User user);

    User search(Integer id);


    Result login(String name, String password);
}
