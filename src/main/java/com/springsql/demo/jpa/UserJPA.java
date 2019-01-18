package com.springsql.demo.jpa;

import com.springsql.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity>, Serializable {
}
