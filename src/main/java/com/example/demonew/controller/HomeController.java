package com.example.demonew.controller;

import com.example.demonew.entity.*;
import com.example.demonew.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class HomeController {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private LunbotuMapper lunbotuMapper;
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private HonorMapper honorMapper;
    @Autowired
    private EmpMapper empMapper;

    @RequestMapping("/index")
    public String index (Model model) {
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        model.addAttribute("lunbotu", lunbotuList);
        List<Dept> deptList=deptMapper.list("");
        model.addAttribute("dept",deptList);
        List<News> newsList=newsMapper.list("");
        model.addAttribute("news", newsList);
        return "index";
    }
    @RequestMapping("/about")
    public String about(Model model) {
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        model.addAttribute("lunbotu", lunbotuList);
        return "about";
    }
    @RequestMapping("/chanpinzhanshi")
    public String chanpinzhanshi(Model model) {
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        model.addAttribute("lunbotu", lunbotuList);
        List<Dept> deptList=deptMapper.list("");
        model.addAttribute("dept",deptList);
        return "chanpinzhanshi";
    }
    @RequestMapping("/xinwen")
    public String news(Model model) {
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        model.addAttribute("lunbotu", lunbotuList);
        List<News> newsList=newsMapper.list("");
        model.addAttribute("news", newsList);
        return "news";
    }
    @RequestMapping("/rongyu")
    public String honor(Model model) {
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        model.addAttribute("lunbotu", lunbotuList);
        List<Honor> honorList=honorMapper.list("");
        model.addAttribute("honor", honorList);
        return "honor";
    }
    @RequestMapping("/connect")
    public String connect(Model model) {
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        model.addAttribute("lunbotu", lunbotuList);
        return "connect";
    }
    @RequestMapping("/anlizhanshi")
    public String anlizhanshi(Model model) {
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        model.addAttribute("lunbotu", lunbotuList);
        List<Emp> empList=empMapper.list("");
        model.addAttribute("emp", empList);
        return "anlizhanshi";
    }
    @GetMapping("/chanpinzhanshi/{id}")
    public ModelAndView searchchanpin(@PathVariable Integer id)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("dept");
        Dept dept = deptMapper.search(id);
        view.addObject("dept",dept);
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        view.addObject("lunbotu",lunbotuList);
        return view;
    }
    @GetMapping("/xinwen/{id}")
    public ModelAndView searchxinwen(@PathVariable Integer id)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("new");
        News news = newsMapper.search(id);
        view.addObject("news",news);
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        view.addObject("lunbotu",lunbotuList);
        return view;
    }
    @GetMapping("/rongyu/{id}")
    public ModelAndView searchrongyu(@PathVariable Integer id)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("rongyu");
        Honor honor = honorMapper.search(id);
        view.addObject("honor",honor);
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        view.addObject("lunbotu",lunbotuList);
        return view;
    }
    @GetMapping("/anlizhanshi/{id}")
    public ModelAndView searchemp(@PathVariable Integer id)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("emp");
        Emp emp = empMapper.search(id);
        view.addObject("emp",emp);
        List<Lunbotu> lunbotuList=lunbotuMapper.list("");
        view.addObject("lunbotu",lunbotuList);
        return view;
    }
}
