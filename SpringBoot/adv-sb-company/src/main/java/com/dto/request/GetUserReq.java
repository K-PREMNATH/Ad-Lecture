package com.dto.request;

public class GetUserReq {
    private int userDetailId;

    public int getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(int userDetailId) {
        this.userDetailId = userDetailId;
    }

    @Override
    public String toString() {
        return "GetUserReq{" +
                "userDetailId=" + userDetailId +
                '}';
    }
}
