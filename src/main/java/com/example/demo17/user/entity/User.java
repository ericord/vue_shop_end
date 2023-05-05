package com.example.demo17.user.entity;

import com.example.demo17.common.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author chaonianye
 * @description
 * @date 2023/4/29
 */
@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ids")
    @GenericGenerator(name = "ids", strategy = "com.example.demo17.common.UUIDGenerator")
    private String id;
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @Column(name = "USER_CODE")
    private String userCode;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "CREATE_TIME")
//    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime createTime;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "email")
    private String email;
    @Column(name = "status")
    private Integer status;//1->启用;2->禁用
    @Transient
    private String roleName;



}
