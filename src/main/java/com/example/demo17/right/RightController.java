package com.example.demo17.right;

import com.example.demo17.common.MapBeanUtil;
import com.example.demo17.common.Result;
import com.example.demo17.right.dao.RightRepository;
import com.example.demo17.right.entity.Right;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chaonianye
 * @description
 * @date 2023/5/20
 */
@RestController
public class RightController {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private RightRepository rightRepository;

    @GetMapping(value = "/rights")
    public Result users() {
        Map result = new HashMap<>();

        StringBuilder sql = new StringBuilder("select * from rights ");
//        if (StringUtils.hasLength(user.getUserName())) {
//            sql.append(" and u.user_name like concat('%',:userName, '%')");
//        }
//        Query countQuery = entityManager.createNativeQuery("select count(1) from (" + sql + ") as h");
//        Integer offset = (pagenation.getPageNum() - 1) * pagenation.getPageSize();
//        Query listQuery = entityManager.createNativeQuery(sql + " limit :pageSize offset :offset");
        Query listQuery = entityManager.createNativeQuery(sql.toString());
        listQuery.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        if (StringUtils.hasLength(user.getUserName())) {
//            countQuery.setParameter("userName", user.getUserName());
//            listQuery.setParameter("userName", user.getUserName());
//
//        }
//        listQuery.setParameter("pageSize", pagenation.getPageSize());
//        listQuery.setParameter("offset", offset);
//        List totalElements = countQuery.getResultList();
//        Long total = Long.valueOf(String.valueOf(totalElements.get(0)));
        List<Right> resultList = null;
//        if (total > 0) {
            resultList = listQuery.getResultList();
//        }
        List<Right> rights = MapBeanUtil.mapToBean(resultList, Right.class);
//        result.put("pageNum", pagenation.getPageNum());
//        result.put("total", total);
        result.put("rights", rights);
        return Result.ok(result);
    }
}
