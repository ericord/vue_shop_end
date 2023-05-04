package com.example.demo17.user.dao;

import com.example.demo17.menu.entity.Menus;
import com.example.demo17.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
