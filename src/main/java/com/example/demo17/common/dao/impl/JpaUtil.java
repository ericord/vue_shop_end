package com.example.demo17.common.dao.impl;

import com.example.demo17.common.MapBeanUtil;
import com.example.demo17.common.entity.BaseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author chaonianye
 * @description
 * @date 2023/5/4
 */
public class JpaUtil {

    public static <T extends JpaRepository, S extends BaseEntity> void cSave(T repository, S entity) {
        Optional op = repository.findById(entity.getId());
        Object old = op.get();
        if (old == null) {
            repository.save(entity);
        } else {
            BeanUtils.copyProperties(entity, old, MapBeanUtil.getNullPropertyNames(entity));
            repository.save(old);
        }
    }
}
