package com.qs304.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qs304.entity.Emplovee;
import com.qs304.service.EmplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmploConttroller{

    @Autowired
    EmplService service;
    @RequestMapping("/getListJson")
    @ResponseBody
    public PageInfo getListWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
        PageHelper.startPage(pn,5);
        List<Emplovee> listservice=service.getEmploveeList(null);
        PageInfo page=new PageInfo(listservice);
        return page;
    }

    @RequestMapping("/getList")
    public String getList(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
        PageHelper.startPage(pn,5);
        List<Emplovee> listservice=service.getEmploveeList(null);
        PageInfo page=new PageInfo(listservice);
        model.addAttribute("pageInfo",page);
        return "list";
    }
}
