package com.springsql.demo.controller;

import com.springsql.demo.entity.UserEntity;
import com.springsql.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    /**
     * 查询用户列表方法
     * @return
     * */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> list() {
        return userJPA.findAll();
    }
    /**
     * 添加、更新用户
     * @param entity
     * */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public UserEntity save(UserEntity entity) {
        return userJPA.save(entity);
    }
    /**
     * 删除用户
     * @param id
     * @return
     * */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<UserEntity> delete(int id) {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
