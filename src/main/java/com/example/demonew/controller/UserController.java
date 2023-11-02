package com.example.demonew.controller;

import com.example.demonew.entity.*;
import com.example.demonew.utils.Result;
import com.example.demonew.service.UserService;
import com.example.demonew.utils.JwtUtils;
import com.example.demonew.utils.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController//里面包含了responsebody自动把返回值转为json
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize,String name,Integer gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin ,@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
        PageBean pageBean = userService.page(page, pageSize,name, gender, begin,end);


        log.info("当前页是{},每页记录数是{},名字是{},性别是{},开始日期是{}，结束日期是{}",page,pageSize,name,gender,begin,end);


        return Result.success(pageBean);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable  List<Integer> ids)
    {
        userService.delete(ids);
//        log.info(ids.toString());
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody User user)
    {
        return userService.add(user);
    }
    @PutMapping
    public  Result updata(@RequestBody User user)
    {
        userService.updata(user);
        return  Result.success();
    }
    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id)
    {

        return  Result.success(userService.search(id));
    }
    @PostMapping("/login")
    public Result login(@RequestBody User a) {
        log.info("这是name{},这是password{}",a.getName(),a.getPassword());
        Result result = userService.login(a.getName(),a.getPassword());
        log.info("server返回回来的result是"+result);
        User user = (User) result.getData();
        log.info("result里的data是"+ user);
        if(result.getCode()==1){
            Map<String,Object> claims=new HashMap<>();
            claims.put("name",user.getName());
            claims.put("username",user.getUsername());
            claims.put("id",user.getId());
            log.info("map里的claims是"+ claims);
            String jwt= JwtUtils.generateJwt(claims);
            Result rs = new Result(1,user.getId().toString(),jwt);
            return rs;
        }
        return Result.error("用户名或密码错误");
    }




}

