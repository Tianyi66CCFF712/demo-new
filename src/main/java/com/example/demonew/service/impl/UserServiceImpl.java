package com.example.demonew.service.impl;


import com.example.demonew.utils.PageBean;
import com.example.demonew.utils.Result;
import com.example.demonew.entity.User;

import com.example.demonew.mapper.UserMapper;
import com.example.demonew.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

//    public PageBean page(Integer page, Integer pageSize,String name, Integer gender, LocalDate begin,LocalDate end) {
//        Long count = userMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<user> userList = userMapper.page(start, pageSize,name, gender, begin,end);
//        PageBean pageBean = new PageBean(count, userList);
//        return pageBean;
//    }原始分页查询

    @Override
    public void delete(List<Integer> ids) {
        userMapper.deleteByid(ids);
//        System.out.println(ids);
    }

    @Override
    public Result add(User user) {
        if (userMapper.list(user.name, null, null, null).isEmpty()) {
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            userMapper.add(user);
            return Result.success();
        }
        else return Result.error("用户名已被占用");
    }

    @Override
    public void updata(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public User search(Integer id) {

        return userMapper.search(id);
    }

    @Override
    public Result login(String name, String password) {
        System.out.println(name + " serives层的名字和密码 " + password);
            List<User> list = userMapper.login(name, password);
            if (!list.isEmpty()) {
                System.out.println("这是list的0"+list.get(0));
                return Result.success(list.get(0));
            }
            return Result.error("用户名或密码错误");
    }

    public PageBean page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询,也不用加limit限制，原来的limit是用于分页的，里面是start和每页记录数
        List<User> userList = userMapper.list(name, gender, begin, end);
        //封装pagebean，要把userList转为Page类型的以便调用pagehelper的方法
        Page<User> p = (Page<User>) userList;
        PageBean pageBeanUser = new PageBean(p.getTotal(), p.getResult());
        return pageBeanUser;
    }
}
