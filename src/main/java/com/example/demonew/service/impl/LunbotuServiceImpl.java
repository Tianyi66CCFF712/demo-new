package com.example.demonew.service.impl;

import com.example.demonew.entity.Lunbotu;
import com.example.demonew.utils.PageBean;
import com.example.demonew.mapper.LunbotuMapper;
import com.example.demonew.service.LunbotuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LunbotuServiceImpl implements LunbotuService {
    @Autowired
    private LunbotuMapper lunbotuMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询,也不用加limit限制，原来的limit是用于分页的，里面是start和每页记录数
        List<Lunbotu> lunbotuList = lunbotuMapper.list(name);
        //封装pagebean，要把empList转为Page类型的以便调用pagehelper的方法
        Page<Lunbotu> p = (Page<Lunbotu>) lunbotuList;
        PageBean pageBeanLunbotu = new PageBean(p.getTotal(), p.getResult());
        return pageBeanLunbotu;
    }

    @Override
    public void delete(List<Integer> ids) {
        lunbotuMapper.deleteByid(ids);
    }

    @Override
    public void add(Lunbotu lunbotu) {
        lunbotu.setCreateTime(LocalDateTime.now());
        lunbotu.setUpdateTime(LocalDateTime.now());
        lunbotuMapper.add(lunbotu);
    }

    @Override
    public void updata(Lunbotu lunbotu) {
        lunbotu.setUpdateTime(LocalDateTime.now());
        lunbotuMapper.update(lunbotu);
    }

    @Override
    public Lunbotu search(Integer id) {
        return lunbotuMapper.search(id);
    }
}
