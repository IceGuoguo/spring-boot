package com.bing.controller;

import com.bing.entity.User;
import com.bing.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guobing
 * @version 1.0
 * @date 2019/9/3 下午3:39
 * @description
 */

@Controller
@RequestMapping(value = "/formUserManager")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping(value = "/registerUser")
    @ResponseBody
    public void registerUser(User user) throws IOException {
        if(iUserService.queryUserByNameAndPassword(user) != null){
            System.out.println("用户已存在，请重新注册~");
        }else {
            iUserService.saveUser(user);
        }

    }

    @PostMapping(value = "/addUser")
    @ResponseBody
    public void addUser(User user) throws IOException {
        iUserService.saveUser(user);
    }

    @GetMapping(value = "/queryUserById")
    @ResponseBody
    public User queryUserById(@RequestParam(value = "id") Integer id){
        //从数据库中查询
        return iUserService.queryUserById(id);
    }

    @GetMapping(value = "/queryUserCount")
    @ResponseBody
    public Integer queryUserCount(@RequestParam(value = "column") String column,
                               @RequestParam(value = "value") String value){
        //从数据库中查询
        return iUserService.queryUserCount(column,value);
    }

    @GetMapping(value = "/queryUserByPage")
    @ResponseBody
    public Map<String,Object> queryUserByPage(@RequestParam(value = "page",defaultValue = "1") Integer pageNow,
                                              @RequestParam(value = "rows",defaultValue = "10") Integer pageSize,
                                              @RequestParam(value = "column",required = false) String column,
                                              @RequestParam(value = "value",required = false) String value){

        Map<String,Object> users = new HashMap<>();
        users.put("第 "+pageNow+" 页：",iUserService.queryUserByPage(pageNow,pageSize,column,value));
        return users;
    }


    @DeleteMapping(value = "/deleteUserByIds")
    @ResponseBody
    public void deleteUserByIds(@RequestParam(value = "ids") Integer[] ids){

        iUserService.deleteByUserIds(ids);
    }

    @PutMapping(value = "/updateUser")
    @ResponseBody
    public void updateUser(User user) throws IOException {
        iUserService.updateUser(user);
    }

    @PostMapping(value = "/userLogin")
    @ResponseBody
    public void userLogin(User user) throws JsonProcessingException {

        User user_sel = iUserService.queryUserByNameAndPassword(user);
        if (user_sel == null){
            System.out.println("该用户不存在！请先注册~");
        }else if(user.getPassword().equals(user_sel.getPassword())){
            System.out.println("密码错误！请重新输入~");
        }else {
            System.out.println("登录成功！");
        }

    }

}
