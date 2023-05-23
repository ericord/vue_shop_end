package com.example.demo17.right.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author chaonianye
 * @description
 * @date 2023/5/20
 */
@Data
@Entity
@Table(name = "rights")
public class Right {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id")
    @GenericGenerator(name = "id", strategy = "com.example.demo17.common.UUIDGenerator")
    private String id;

    /**
     * 权限名称
     */
    @Column(name = "RIGHT_NAME")
    private String rightName;
    /**
     * 路径
     */
    @Column(name = "PATH")
    private String path;
    /**
     * 权限等级
     */
    @Column(name = "LEVEL")
    private Integer level;
}
