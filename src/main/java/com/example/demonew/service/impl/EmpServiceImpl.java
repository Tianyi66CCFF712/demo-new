package com.example.demonew.service.impl;

import com.example.demonew.entity.Emp;
import com.example.demonew.utils.PageBean;
import com.example.demonew.mapper.EmpMapper;
import com.example.demonew.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

//    public PageBean page(Integer page, Integer pageSize,String name, Integer gender, LocalDate begin,LocalDate end) {
//        Long count = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize,name, gender, begin,end);
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;
//    }原始分页查询

    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteByid(ids);
//        System.out.println(ids);
    }

    @SneakyThrows
    @Override
    public void add(Emp emp) {
//        String originalURL = emp.getImage();
//        String newHostname = "192.168.116.142";
//
//        // 解析原始URL
//        URL url = new URL(originalURL);
//
//        // 获取协议（http://）、主机（192.168.146.142）和路径部分（/img/1694677387157三亚观音.jpg）
//        String protocol = url.getProtocol();
//        String path = url.getPath();
//        // 获取本机的InetAddress对象
//        InetAddress localhost = InetAddress.getLocalHost();
//
//        // 获取本机的IP地址
//        String ipAddress = localhost.getHostAddress();
//        // 创建新URL
//        String newURL = protocol + "://" + newHostname + path;
//        emp.setImage(newURL);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public void updata(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp search(Integer id) {

        return empMapper.search(id);
    }


    public PageBean page(Integer page, Integer pageSize, String name) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询,也不用加limit限制，原来的limit是用于分页的，里面是start和每页记录数
        List<Emp> empList = empMapper.list(name);
        //封装pagebean，要把empList转为Page类型的以便调用pagehelper的方法
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBeanEmp = new PageBean(p.getTotal(), p.getResult());
        return pageBeanEmp;
    }
}



