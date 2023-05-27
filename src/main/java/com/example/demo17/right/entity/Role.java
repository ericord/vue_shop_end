package com.example.demo17.right.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonianye
 * @description
 * @date 2023/5/20
 */
@Data
@Entity
@Table(name = "ROLE")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;
    /**
     * 角色描述
     */
    @Column(name = "ROLE_DESC")
    private String roleDesc;

    @Transient
    private String rightId;

    @Transient
    private String path;
    @Transient
    private String rightName;
    @Transient
    private List<Role> children = new ArrayList<>();


}
