package com.example.demo17.user.entity;

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
public class User {
    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "id", strategy = "uuid")
    private String id;
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @Column(name = "USER_CODE")
    private String userCode;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "CREATE_TIME")
//    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime createTime;
    @Column(name = "MOBILE")
    private String mobile;



}
