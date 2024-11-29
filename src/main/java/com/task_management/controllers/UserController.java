package com.task_management.controllers;

import com.task_management.constants.ResponseMessage;
import com.task_management.utils.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<ResponseDto<String>> home(HttpServletRequest request) {
        return new ResponseEntity<>(ResponseDto.createResponse(ResponseMessage.WELECOM_USER,
                "User Fetched well",
                true, HttpStatus.OK, request, "user"),
                HttpStatus.OK);
    }
}
