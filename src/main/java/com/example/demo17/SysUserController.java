package com.example.demo17;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SysUserController {

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody SysUser sysUser) {
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map21 = new HashMap<>();
        Map<String, Object> map22 = new HashMap<>();
        String username = sysUser.getUsername();
        String password = sysUser.getPassword();
        // 省略 账号密码验证
        // 验证成功后发送token
        String token = JwtUtil.sign(username, password);
        if (token.equals(JwtUtil.LOGIN_FAIL)) {
            map1.put("data", null);
            map22.put("status", 401);
            map22.put("msg", "认证失败");
            map1.put("meta", map22);

        } else {
//        if (token != null) {
////            map21.put("code", "200");
////            map21.put("message", "认证成功");
//            return map1;
//        }
            map21.put("token", token);
            map1.put("data", map21);
            map22.put("status", 200);
            map22.put("msg", "登录成功");
            map1.put("meta", map22);
        }
        return map1;
    }
}