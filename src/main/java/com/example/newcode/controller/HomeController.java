package com.example.newcode.controller;

import com.example.newcode.entity.DiscussPost;
import com.example.newcode.entity.Page;
import com.example.newcode.entity.User;
import com.example.newcode.service.DiscussPostServiceImpl;
import com.example.newcode.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class HomeController {
    @Autowired
    DiscussPostServiceImpl discussPostService;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/index")
    public String getIndexPage(Model model, Page page){
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> mapsList=new ArrayList<>();
        if (list!=null){
            for (DiscussPost post:list){
                Map<String, Object> map=new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                mapsList.add(map);
                System.out.println(post+" "+user);
            }
        }
        model.addAttribute("DiscussPostMap",mapsList);
        return "index";


    }



}
