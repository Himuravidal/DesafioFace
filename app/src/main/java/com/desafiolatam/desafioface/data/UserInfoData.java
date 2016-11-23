package com.desafiolatam.desafioface.data;

import com.desafiolatam.desafioface.model.UserInfo;

/**
 * Created by cristian on 22-11-2016.
 */

public class UserInfoData {

    public boolean isLoged() {
        long count = UserInfo.count(UserInfo.class);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

}
