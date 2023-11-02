package com.example.demonew.controller;

import com.example.demonew.entity.*;
import com.example.demonew.service.LunbotuService;
import com.example.demonew.utils.PageBean;
import com.example.demonew.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lunbotus")
public class LunbotuController {
    @Autowired
    private LunbotuService lunbotuService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String name) {
        PageBean pageBeanLunbotu = lunbotuService.page(page, pageSize,name);
        log.info("当前页是{},每页记录数是{},名字是{}",page,pageSize,name);
        return Result.success(pageBeanLunbotu);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids)
    {
        lunbotuService.delete(ids);
//        log.info(ids.toString());
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Lunbotu lunbotu)
    {
        lunbotuService.add(lunbotu);
        return Result.success();
    }
    @PutMapping
    public  Result updata(@RequestBody Lunbotu lunbotu)
    {
        lunbotuService.updata(lunbotu);
        return  Result.success();
    }
    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id)
    {
        return  Result.success(lunbotuService.search(id));
    }
}
