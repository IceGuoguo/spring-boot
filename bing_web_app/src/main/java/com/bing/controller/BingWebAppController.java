package com.bing.controller;

import com.bing.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guobing
 * @version 1.0
 * @date 2019/9/4 下午4:18
 * @description
 */
@RestController
@RequestMapping(value = "/bingApp")
public class BingWebAppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BingWebAppController.class);

    @Autowired
    private RestTemplate restTemplate;

    //用户注册
    @PostMapping("/register")
    public String register(User user) {
        LOGGER.debug(user.toString());
        String url = "http://localhost:8888/UserModel/managerUser/registerUser";

        restTemplate.postForObject(url, user, User.class);
        return "login";
    }

    //用户登录
    @GetMapping("/login")
    public String login(User user) {
        LOGGER.debug(user.toString());
        String url = "http://localhost:8888/UserModel/managerUser/userLogin";

        restTemplate.postForObject(url, user, User.class);

        return "redirect:/bingApp/showAll";
        //return "hello.html";
    }

    //分页展示所有用户
    @GetMapping("/showAll")
    public String showAll(@RequestParam(value = "page",defaultValue = "1") String page,
                          @RequestParam(value = "rows",defaultValue = "5") String rows,
                          String column, Object value, Model model) {
        String url = "http://localhost:8888/UserModel/managerUser/queryUserByPage?page={page}&rows={rows}&column={column}&value={value}";

        Map<String, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("rows", rows);
        params.put("column", column);
        params.put("value", value);

        User[] users = restTemplate.getForObject(url, User[].class, params);

        model.addAttribute("users",users);

        return "queryAll";
    }

    //批量删除
    @DeleteMapping("/deleteUserByIds")
    public String deleteUserByIds(Integer[] ids) {
        String url="http://localhost:8888/UserModel/managerUser/delteUserByIds?ids={ids}";

        Map<String ,Integer[]> params = new HashMap<>();
        params.put("ids",ids);
        restTemplate.delete(url,params);

        return "redirect:/bingApp/showAll";
    }

    //更新用户信息
    @PutMapping("/updateUserById")
    public String updateUserById(User user){
        String url="http://localhost:8888/UserModel/managerUser/updateUser";

        restTemplate.put(url,user);
        return "redirect:/bingApp/showAll";
    }


}
