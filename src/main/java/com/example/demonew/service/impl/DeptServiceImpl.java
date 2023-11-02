package com.example.demonew.service.impl;

import com.example.demonew.entity.Dept;
import com.example.demonew.utils.PageBean;
import com.example.demonew.mapper.DeptMapper;
import com.example.demonew.service.DeptService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
private DeptMapper deptMapper;
    @Override
    public PageBean list(Integer page, Integer pageSize, String name) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询,也不用加limit限制，原来的limit是用于分页的，里面是start和每页记录数
        List<Dept> deptList=deptMapper.list(name);
        //封装pagebean，要把empList转为Page类型的以便调用pagehelper的方法
        Page<Dept> p = (Page<Dept>) deptList;
        PageBean pageBeanDept = new PageBean(p.getTotal(), p.getResult());
        return pageBeanDept;
    }

    @Override
    public void delete(List<Integer> ids) {
        deptMapper.deleteById(ids);
    }

    @Override
    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept search(Integer id) {

        return deptMapper.search(id);
    }

    @Override
    public void update(Dept dept) {

        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}
