package com.controller;

import com.business.CompanyBusiness;
import com.dto.request.GetUserReq;
import com.dto.request.UserInsertReq;
import com.dto.request.UserUpdateReq;
import com.dto.response.GetUserRes;
import com.dto.response.UserInsertRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/user/get/detail")
    public GetUserRes getUserRecord(@RequestParam("id") String userDetailId){
        LOGGER.info("getUserRecord----------->userDetailId : "+userDetailId);
        GetUserRes getUserRes = companyBusiness.getUserRecord(userDetailId);
        return getUserRes;
    }

    @PostMapping("/user/get/record")
    public GetUserRes getUserRecord(@RequestBody GetUserReq getUserReq){
        LOGGER.info("getUserRecord----------->"+getUserReq.toString());
        GetUserRes getUserRes = companyBusiness.getUserRecord(getUserReq);
        return getUserRes;
    }

    @PostMapping("/user/get/list")
    public List<GetUserRes> getUserList(){
        List<GetUserRes> list = companyBusiness.getUserList();
        return list;
    }
}
