package com.controller;

import com.business.CompanyBusiness;
import com.dto.request.UserInsertReq;
import com.dto.request.UserUpdateReq;
import com.dto.response.UserInsertRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class CompanyController {

    Logger LOGGER = Logger.getLogger(CompanyController.class.getName());

    @Autowired
    CompanyBusiness companyBusiness;

    @PostMapping("/user/insert/record")
    public UserInsertRes insertUserRecord(@RequestBody UserInsertReq userInsertReq){
        LOGGER.info("insertUserRecord----------->"+userInsertReq.toString());

        UserInsertRes userInsertRes = companyBusiness.insertUserRecord(userInsertReq);
        return userInsertRes;
    }

    @PostMapping("/user/update/record")
    public UserInsertRes updateUserRecord(@RequestBody UserUpdateReq userUpdateReq){
        LOGGER.info("updateUserRecord----------->"+userUpdateReq.toString());

        UserInsertRes userInsertRes = companyBusiness.updateUserRecord(userUpdateReq);
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
