package com.example.demo17.menu;

import com.example.demo17.common.Result;
import com.example.demo17.menu.entity.Menus;
import com.example.demo17.menu.dao.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;

    @GetMapping(value = "/menus")
    public Result get() {
        List<Menus> allList = menuRepository.getAllList();
        List<Menus> menuTree = getTree(allList, "/");
        return Result.ok(menuTree);
    }

    List<Menus> getTree(
            List<Menus> allMenus,
            String parentCode) {
        List<Menus> childs = new ArrayList<>();
        String s = "/[0-9]{3}";
        String pattern = parentCode.equals("/") ? s : (parentCode + s);
        //过滤出parentCode的所有所有子节点
        childs = allMenus.stream().filter(e -> e.getId().matches(pattern)).collect(Collectors.toList());
        //循环childs,递归调用
        childs.forEach(e -> {
            e.setChilds(getTree(allMenus, e.getId()));
        });
        return childs;
    }

}