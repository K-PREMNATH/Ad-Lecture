package com.business;

import com.dto.request.CustomerLoginReq;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;

public interface UserBusiness {
    /**
     * userRegistration
     * @param userRegistrationReq
     * @return
     */
    GeneralResponse userRegistration(UserRegistrationReq userRegistrationReq);

    GeneralResponse userLogin(CustomerLoginReq customerLoginReq);
}
