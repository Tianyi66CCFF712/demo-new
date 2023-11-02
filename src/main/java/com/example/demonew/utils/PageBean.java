package com.example.demonew.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    public Long total;//总记录数
    public Object rows;//查询表结果

}
