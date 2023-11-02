package com.example.demonew.controller;

import com.example.demonew.entity.News;
import com.example.demonew.service.NewsService;
import com.example.demonew.utils.PageBean;
import com.example.demonew.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String name){
        log.info("查询全部");
        PageBean pageBean = newsService.list(page, pageSize,name);
        log.info("当前页是{},每页记录数是{},名字是{}",page,pageSize,name);
        log.info("总记录数是{}",pageBean.total);
        return Result.success(pageBean);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable  List<Integer> ids){


        newsService.delete(ids);
//        log.info(ids.toString());
            return Result.success();

    }
    @PostMapping
    public Result insert(@RequestBody News news)
    {
        log.info("添加");
        newsService.insert(news);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id)
    {
        log.info("查询"+id);
        //调用service层功能
        News news= newsService.search(id);
        //响应
        return Result.success(news);
    }
    @PutMapping
    public Result update(@RequestBody News news)
    {
        newsService.update(news);
        //响应
        return Result.success();

    }
}
