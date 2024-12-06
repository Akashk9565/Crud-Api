package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
