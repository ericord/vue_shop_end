package com.example.demo17.right.entity;

import lombok.Data;
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
@Table(name = "rights")
public class Right {
    @Id
    @Column(name = "ID")
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

    @Transient
    private List<Right> children = new ArrayList<>();
}
