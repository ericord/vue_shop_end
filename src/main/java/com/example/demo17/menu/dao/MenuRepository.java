package com.example.demo17.menu.dao;

import com.example.demo17.menu.entity.Menus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menus, String> {

    @Query(value = "select * from user where user_name like ?1", nativeQuery = true)
    List<Menus> fuzzyQueryByName(String userName);

    @Query(value = "select * from menus", nativeQuery = true)
    List<Menus> getAllList();




}
