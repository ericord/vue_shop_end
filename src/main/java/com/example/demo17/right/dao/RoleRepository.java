package com.example.demo17.right.dao;

import com.example.demo17.right.entity.Right;
import com.example.demo17.right.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    @Query(value = "select r.id,r.role_desc,r.role_name,rt.id right_id,rt.path,right_name from role r left join map_role_right rr on rr.role_id=r.id left join rights rt on rt.id=rr.right_id", nativeQuery = true)
    List<Role> findAllRoleRight();
}
