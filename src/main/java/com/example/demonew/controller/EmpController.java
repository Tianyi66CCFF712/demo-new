package com.example.demonew.controller;

import com.example.demonew.entity.Emp;
import com.example.demonew.utils.PageBean;
import com.example.demonew.utils.Result;
import com.example.demonew.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize,String name) {
        PageBean pageBeanEmp = empService.page(page, pageSize,name);


        log.info("当前页是{},每页记录数是{},名字是{}",page,pageSize,name);


        return Result.success(pageBeanEmp);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable  List<Integer> ids)
    {
        empService.delete(ids);
//        log.info(ids.toString());
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Emp emp)
    {
        empService.add(emp);
        return Result.success();
    }
    @PutMapping
    public  Result updata(@RequestBody Emp emp)
    {
        empService.updata(emp);
        return  Result.success();
    }
    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id)
    {
        return  Result.success(empService.search(id));
    }
}
