package com.springsql.demo.controller;

import com.springsql.demo.entity.UserEntity;
import com.springsql.demo.jpa.UserJPA;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class LoginController {
    private UserJPA userJPA;
    @RequestMapping(value = "/login")
    public String login(UserEntity user, HttpServletRequest request) {

        String result = "登录成功";

        boolean flag = true;

        Optional<UserEntity> userEntity = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });
        // 用户不存在
        if (!userEntity.isPresent()) {
            result = "用户不存在，登录失败";
            flag = false;
        }
        // 密码错误
        else if(!userEntity.get().getPwd().equals(user.getPwd())) {
            result = "用户密码不相符，登录失败";
            flag = false;
        }
        // 登录成功
        if (flag) {
            // 将用户写入session
            request.getSession().setAttribute("_session_user", userEntity);
        }
        return result;
    }
}
