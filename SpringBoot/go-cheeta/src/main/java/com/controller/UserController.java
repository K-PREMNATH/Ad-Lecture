package com.controller;

import com.dto.request.CustomerLoginReq;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;

public interface UserController {
    /**
     * userRegistration
     * @param userRegistrationReq
     * @return
     */
    public GeneralResponse userRegistration(UserRegistrationReq userRegistrationReq);

    public GeneralResponse customerLogin(CustomerLoginReq customerLoginReq);

    //public GeneralResponse adminLogin(CustomerLoginReq customerLoginReq);
}
