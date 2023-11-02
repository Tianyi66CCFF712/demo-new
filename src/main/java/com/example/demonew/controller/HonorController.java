package com.example.demonew.controller;

import com.example.demonew.entity.Honor;

import com.example.demonew.service.HonorService;

import com.example.demonew.utils.PageBean;
import com.example.demonew.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/honor")
public class HonorController {
    @Autowired
    private HonorService honorService;

    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String name) {
        log.info("查询全部");
        PageBean pageBean = honorService.list(page, pageSize, name);
        log.info("当前页是{},每页记录数是{},名字是{}", page, pageSize, name);
        log.info("总记录数是{}", pageBean.total);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {


        honorService.delete(ids);
//        log.info(ids.toString());
        return Result.success();

    }

    @PostMapping
    public Result insert(@RequestBody Honor honor) {
        log.info("添加");
        honorService.insert(honor);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id) {
        log.info("查询" + id);
        //调用service层功能
        Honor honor = honorService.search(id);
        //响应
        return Result.success(honor);
    }

    @PutMapping
    public Result update(@RequestBody Honor honor) {
        honorService.update(honor);
        //响应
        return Result.success();
    }
}
