package com.example.spring_oauth2_authorization_server.controller;

import com.example.spring_oauth2_authorization_server.dto.UserDTO;
import com.example.spring_oauth2_authorization_server.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 기본 로그인의 회원 가입을 위한 엔드포인트
@Controller
public class JoinController {

    private final UserService userService;

    public JoinController(UserService userService) {
        this.userService = userService;
    }

    // 회원 가입 페이징 응답
    @GetMapping("/join")
    public String joinPage() {

        return "joinPage";
    }

    // 회원가입 Form으로 부터 dto 받는 프로세스
    @PostMapping("/join")
    @ResponseBody
    public String join(UserDTO dto) {

        userService.join(dto);

        return "ok";
    }
}
