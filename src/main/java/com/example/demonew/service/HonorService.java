package com.example.demonew.service;


import com.example.demonew.entity.Honor;
import com.example.demonew.utils.PageBean;

import java.util.List;

public interface HonorService {
     PageBean list(Integer page, Integer pageSize, String name);
     void delete(List<Integer> ids);
     void insert(Honor honor);
     Honor search(Integer id);
     void update(Honor honor);
}
