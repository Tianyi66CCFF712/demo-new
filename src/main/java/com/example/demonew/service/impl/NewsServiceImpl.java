package com.example.demonew.service.impl;
import com.example.demonew.entity.News;
import com.example.demonew.mapper.NewsMapper;
import com.example.demonew.service.NewsService;
import com.example.demonew.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
private NewsMapper newsMapper;
    @Override
    public PageBean list(Integer page, Integer pageSize, String name) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询,也不用加limit限制，原来的limit是用于分页的，里面是start和每页记录数
        List<News> newsList=newsMapper.list(name);
        //封装pagebean，要把empList转为Page类型的以便调用pagehelper的方法
        Page<News> p = (Page<News>) newsList;
        PageBean pageBeanNews = new PageBean(p.getTotal(), p.getResult());
        return pageBeanNews;
    }

    @Override
    public void delete(List<Integer> ids) {
        newsMapper.deleteById(ids);
    }

    @Override
    public void insert(News news) {
        news.setCreateTime(LocalDateTime.now());
        news.setUpdateTime(LocalDateTime.now());
        newsMapper.insert(news);
    }

    @Override
    public News search(Integer id) {

        return newsMapper.search(id);
    }

    @Override
    public void update(News news) {

        news.setUpdateTime(LocalDateTime.now());
        newsMapper.update(news);
    }
}
