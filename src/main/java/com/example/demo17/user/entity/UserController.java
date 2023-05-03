package com.example.demo17.user.entity;

import com.example.demo17.common.MapBeanUtil;
import com.example.demo17.common.Result;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @PersistenceContext
    EntityManager entityManager;

    @GetMapping(value = "/users")
    public Result users(User user, Pagenation pagenation) {
        Map result = new HashMap<>();

        StringBuilder sql = new StringBuilder("select u.*, r.role_name from user u left join role r on u.role_code=r.role_code where 1=1 ");
        if (StringUtils.hasLength(user.getUserName())) {
            sql.append(" and u.username like concat('%',:userName, '%'");
        }
        Query countQuery = entityManager.createNativeQuery("select count(1) from (" + sql + ") as h");
        Integer offset = (pagenation.getPageNum() - 1) * pagenation.getPageSize();
        Query listQuery = entityManager.createNativeQuery(sql + " limit :pageSize offset :offset");
        listQuery.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        if (StringUtils.hasLength(user.getUserName())) {
            countQuery.setParameter("userName", user.getUserName());
            listQuery.setParameter("userName", user.getUserName());

        }
        listQuery.setParameter("pageSize", pagenation.getPageSize());
        listQuery.setParameter("offset", offset);
        List totalElements = countQuery.getResultList();
        Long total = Long.valueOf(String.valueOf(totalElements.get(0)));
        List<User> resultList = null;
        if (total > 0) {
            resultList = listQuery.getResultList();
        }
        List<User> users = MapBeanUtil.mapToBean(resultList, User.class);
        result.put("pagenum", pagenation.getPageNum());
        result.put("totle", total);
        result.put("users", users);
        return Result.ok(result);
    }


}