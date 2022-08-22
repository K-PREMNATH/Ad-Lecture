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

    /**
     * customerLogin
     * @param customerLoginReq
     * @return
     */
    public GeneralResponse userLogin(CustomerLoginReq customerLoginReq);
}
