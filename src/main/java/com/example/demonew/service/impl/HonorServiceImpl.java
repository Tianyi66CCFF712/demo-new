package com.example.demonew.service.impl;

import com.example.demonew.entity.Honor;

import com.example.demonew.mapper.HonorMapper;
import com.example.demonew.service.HonorService;

import com.example.demonew.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HonorServiceImpl implements HonorService {
    @Autowired
    private HonorMapper honorMapper;

    @Override
    public PageBean list(Integer page, Integer pageSize, String name) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询,也不用加limit限制，原来的limit是用于分页的，里面是start和每页记录数
        List<Honor> honorList = honorMapper.list(name);
        //封装pagebean，要把empList转为Page类型的以便调用pagehelper的方法
        Page<Honor> p = (Page<Honor>) honorList;
        PageBean pageBeanHonor = new PageBean(p.getTotal(), p.getResult());
        return pageBeanHonor;
    }

    @Override
    public void delete(List<Integer> ids) {
        honorMapper.deleteById(ids);
    }

    @Override
    public void insert(Honor honor) {
        honor.setCreateTime(LocalDateTime.now());
        honor.setUpdateTime(LocalDateTime.now());
        honorMapper.insert(honor);
    }

    @Override
    public Honor search(Integer id) {

        return honorMapper.search(id);
    }

    @Override
    public void update(Honor honor) {

        honor.setUpdateTime(LocalDateTime.now());
        honorMapper.update(honor);
    }
}
