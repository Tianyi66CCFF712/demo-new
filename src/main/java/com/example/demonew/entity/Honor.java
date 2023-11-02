package com.example.demonew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 资质荣誉
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Honor {
    private Integer id; //ID
    private String name; //名称
    private String content;
    private String image;
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
