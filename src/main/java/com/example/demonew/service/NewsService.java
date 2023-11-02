package com.example.demonew.service;


import com.example.demonew.entity.News;
import com.example.demonew.utils.PageBean;

import java.util.List;

public interface NewsService {
     PageBean list(Integer page, Integer pageSize, String name);
     void delete(List<Integer> ids);
     void insert(News news);
     News search(Integer id);
     void update(News news);
}
