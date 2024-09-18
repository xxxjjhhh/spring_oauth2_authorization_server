package com.example.spring_oauth2_authorization_server.controller;

import com.example.spring_oauth2_authorization_server.dto.UserDTO;
import com.example.spring_oauth2_authorization_server.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoinController {

    private final UserService userService;

    public JoinController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/join")
    public String joinPage() {

        return "joinPage";
    }

    @PostMapping("/join")
    @ResponseBody
    public String join(UserDTO dto) {

        userService.join(dto);

        return "ok";
    }
}
