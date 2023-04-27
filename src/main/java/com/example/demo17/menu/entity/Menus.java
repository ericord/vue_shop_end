package com.example.demo17.menu.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "menus")
@EntityListeners(value = AuditingEntityListener.class)
public class Menus {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
    @Column(name = "levelnum")
    private Integer levelnum;
    @Column(name = "leafflag")
    private Integer leafflag;
    @Column(name = "path")
    private String path;
    @Transient
    private List<Menus> childs = new ArrayList<>();
}