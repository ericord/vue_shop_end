package com.example.demo17.right;

import com.example.demo17.common.MapBeanUtil;
import com.example.demo17.common.Result;
import com.example.demo17.right.dao.RightRepository;
import com.example.demo17.right.dao.RoleRepository;
import com.example.demo17.right.entity.Right;
import com.example.demo17.right.entity.Role;
import com.example.demo17.user.entity.User;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RightRepository rightRepository;

    @Autowired
    private EntityManager entityManager;

    @GetMapping(value = "/role/tree")
    public Result tree() {
        Map result = new HashMap<>();

        StringBuilder sql = new StringBuilder("select r.id,r.role_desc,r.role_name,rt.id right_id,rt.path,right_name from role r left join map_role_right rr on rr.role_id=r.id left join rights rt on rt.id=rr.right_id ");
        Query listQuery = entityManager.createNativeQuery(sql.toString());
        listQuery.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Role> resultList = null;
        resultList = listQuery.getResultList();
        List<Role> allRoles = MapBeanUtil.mapToBean(resultList, Role.class);
        Map<Role, List<Role>> roleMap = allRoles.stream().collect(Collectors.groupingBy(e ->
                new Role(e.getId(), e.getRoleName(), e.getRoleDesc(), null, null, null, null)));
        roleMap.forEach((k, v) -> k.setChildren(
                getTree(v, "/")
        ));
        List roles = new ArrayList(roleMap.keySet());
//        List<Right> rightList = rightRepository.findAll();
//        List<Right> roleTree = getTree(rightList, "/");
        result.put("roles", roles);
        return Result.ok(result);
    }

    List<Role> getTree(
            List<Role> allRight,
            String parentCode) {
        List<Role> childs = new ArrayList<>();
        String s = "/[0-9]{3}";
        String pattern = parentCode.equals("/") ? s : (parentCode + s);
        //过滤出parentCode的所有所有子节点
        childs = allRight.stream().filter(e -> e.getRightId().matches(pattern)).collect(Collectors.toList());
        //循环childs,递归调用
        childs.forEach(e -> {
            e.setChildren(getTree(allRight, e.getRightId()));
        });
        return childs;
    }

}