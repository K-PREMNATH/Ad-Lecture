package com.business.impl;

import com.business.UserBusiness;
import com.dao.UserDAO;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    UserDAO userDAO;
    @Override
    public GeneralResponse userRegistration(UserRegistrationReq userRegistrationReq) {
        return userDAO.userRegistration(userRegistrationReq);
    }
}
