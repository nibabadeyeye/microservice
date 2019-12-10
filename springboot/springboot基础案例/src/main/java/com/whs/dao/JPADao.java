package com.whs.dao;

import com.whs.pojo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPADao extends JpaRepository<UserEntity,Integer> {
}
