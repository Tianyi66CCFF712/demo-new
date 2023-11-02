package com.example.demonew.service;

import com.example.demonew.entity.Lunbotu;
import com.example.demonew.utils.PageBean;

import java.util.List;

public interface LunbotuService {

    PageBean page(Integer page, Integer pageSize, String name);
    void delete(List<Integer> ids);


    void add(Lunbotu lunbotu);

    void updata(Lunbotu lunbotu);

    Lunbotu search(Integer id);


}
