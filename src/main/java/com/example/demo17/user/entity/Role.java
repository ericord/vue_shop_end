//package com.example.demo17.user.entity;
//
//import lombok.Data;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.time.LocalDateTime;
//
///**
// * @author chaonianye
// * @description
// * @date 2023/4/30
// */
//@Data
//@Entity
//@Table(name = "role")
//public class Role {
//    @Id
//    @Column(name = "ID")
//    @GenericGenerator(name = "id", strategy = "uuid")
//    private String id;
//    @Column(name = "ROLE_CODE")
//    private String roleCode;
//    @Column(name = "ROLE_NAME")
//    private String roleName;
//    @Column(name = "CREATE_TIME")
//    private LocalDateTime createTime;
//}
