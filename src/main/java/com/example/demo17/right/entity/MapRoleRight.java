package com.example.demo17.right.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author chaonianye
 * @description
 * @date 2023/5/20
 */
@Data
@Entity
@Table(name = "MAP_ROLE_RIGHT")
public class MapRoleRight {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id")
    @GenericGenerator(name = "id", strategy = "com.example.demo17.common.UUIDGenerator")
    private String id;

    /**
     * 权限id
     */
    @Column(name = "RIGHT_id")
    private String rightId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private String roleId;

}
