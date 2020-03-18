package com.arrayteam.argo.server.dao.response;


import com.arrayteam.argo.server.dao.model.User;


public final class UserResponse extends Response<User, UserResponse> {

    public UserResponse() {
        super(UserResponse.class);
    }

}
