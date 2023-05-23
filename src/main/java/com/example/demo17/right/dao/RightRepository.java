package com.example.demo17.right.dao;

import com.example.demo17.right.entity.Right;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chaonianye
 * @description
 * @date 2023/5/20
 */
@Repository
public interface RightRepository extends CrudRepository<Right, String> {
}
