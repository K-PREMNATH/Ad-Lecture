package com.dao;

import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;

public interface UserDAO {
    /**
     * userRegistration
     * @param userRegistrationReq
     * @return
     */
    GeneralResponse userRegistration(UserRegistrationReq userRegistrationReq);
}
