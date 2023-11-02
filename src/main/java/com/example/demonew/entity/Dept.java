package com.example.demonew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 产品
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id; //ID
    private String name; //名称
    private String image;
    private String content;//内容
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
