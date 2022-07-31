package com.controller;

import com.dto.request.UserInsertReq;
import com.dto.request.UserUpdateReq;
import com.dto.response.UserInsertRes;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @PostMapping("/user/insert/record")
    public UserInsertRes insertUserRecord(@RequestBody UserInsertReq userInsertReq){
        System.out.println(userInsertReq.toString());
        UserInsertRes userInsertRes = new UserInsertRes();
        userInsertRes.setStatusCode(1000);
        userInsertRes.setMessage("Success");
        return userInsertRes;
    }

    @PostMapping("/user/update/record")
    public UserInsertRes updateUserRecord(@RequestBody UserUpdateReq userUpdateReq){
        System.out.println(userUpdateReq.toString());
        UserInsertRes userInsertRes = new UserInsertRes();
        userInsertRes.setStatusCode(1000);
        userInsertRes.setMessage("Success");
        return userInsertRes;
    }

    @GetMapping("/user/get/record")
    public UserInsertRes getUserRecord(@RequestParam("id") String userDetailId){
        System.out.println("ID : "+userDetailId);
        UserInsertRes userInsertRes = new UserInsertRes();
        userInsertRes.setStatusCode(1000);
        userInsertRes.setMessage("Success");
        return userInsertRes;
    }

    @GetMapping("/user/delete/record/{userDetailId}")
    public UserInsertRes deleteUserRecord(@PathVariable String userDetailId){
        System.out.println("ID : "+userDetailId);
        UserInsertRes userInsertRes = new UserInsertRes();
        userInsertRes.setStatusCode(1000);
        userInsertRes.setMessage("Success");
        return userInsertRes;
    }
}
