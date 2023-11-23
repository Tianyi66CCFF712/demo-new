package com.example.demonew.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public String name;//唯一的
    public String username;
    public String password;
    public String phone;
    public String email;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer gender;
    public String image;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
