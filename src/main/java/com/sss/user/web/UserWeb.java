package com.sss.user.web;

import com.github.pagehelper.PageInfo;
import com.sss.user.entity.User;
import com.sss.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/28.
 */
@RequestMapping("/user")
@Controller
public class UserWeb {
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home() {
        return "/home";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Object query(User user, int start, @RequestParam(defaultValue = "10") int limit) {
        Map<String, Object> cond = new HashMap<>();
        cond.put("name", user.getName());
        cond.put("address", user.getAddress());
        PageInfo<User> page = userService.queryPage(cond, start, limit);
        Map<String, Object> res = new HashMap<>();
        res.put("rows", page.getList());
        res.put("results", page.getTotal());
        return res;
    }

    @RequestMapping("/del")
    @ResponseBody
    public void delUserBy(Long... ids) {
        for (Long id : ids) {
            userService.delUserBy(id);
        }
    }

    @RequestMapping("/save")
    @ResponseBody
    public void saveUser(User user) {
        userService.save(user);
    }


    @RequestMapping("/login")
    public String login(User user) {
        return "home";
    }
}
