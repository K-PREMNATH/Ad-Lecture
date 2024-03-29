package com.business;

import com.dao.CompanyDAO;
import com.dto.request.GetUserReq;
import com.dto.request.UserInsertReq;
import com.dto.request.UserUpdateReq;
import com.dto.response.GetUserRes;
import com.dto.response.UserInsertRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public GetUserRes getUserRecord(String userDetailId) {
        GetUserReq getUserReq = new GetUserReq();
        getUserReq.setUserDetailId(Integer.parseInt(userDetailId));
        return companyDAO.getUserRecord(getUserReq);
    }

    public GetUserRes getUserRecord(GetUserReq getUserReq) {
        return companyDAO.getUserRecord(getUserReq);
    }


    public List<GetUserRes> getUserList() {
        return companyDAO.getUserList();
    }
}
