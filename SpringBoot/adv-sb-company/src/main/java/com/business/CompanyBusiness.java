package com.business;

import com.dao.CompanyDAO;
import com.dto.request.UserInsertReq;
import com.dto.request.UserUpdateReq;
import com.dto.response.UserInsertRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyBusiness {
    @Autowired
    CompanyDAO companyDAO;

    public UserInsertRes insertUserRecord(UserInsertReq userInsertReq) {
        UserInsertRes  userInsertRes = new UserInsertRes();
        int result = companyDAO.insertUserRecord(userInsertReq);
        if(result > 0){
            userInsertRes.setMessage("Successfully Inserted!!!");
            userInsertRes.setStatusCode(1000);
        }else {
            userInsertRes.setMessage("Failed!!!");
            userInsertRes.setStatusCode(1001);
        }

        return userInsertRes;
    }

    public UserInsertRes updateUserRecord(UserUpdateReq userUpdateReq) {
        UserInsertRes  userInsertRes = new UserInsertRes();
        int result = companyDAO.updateUserRecord(userUpdateReq);
        if(result > 0){
            userInsertRes.setMessage("Successfully Inserted!!!");
            userInsertRes.setStatusCode(1000);
        }else {
            userInsertRes.setMessage("Failed!!!");
            userInsertRes.setStatusCode(1001);
        }

        return userInsertRes;
    }
}
