package com.example.demonew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lunbotu {
    private Integer id; //ID
    private String name; //名称
    private String image; //图像url
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
