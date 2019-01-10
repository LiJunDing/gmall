package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> getUserInfoList();

    UserInfo getUserInfoById(String id);

    void saveUserInfo(UserInfo userInfo);

    void deleteUserInfoById(String id);

    void updateUserInfo(UserInfo userInfo);

    List<UserAddress> getuserAddressList();

    UserAddress getUserAddressbyId(String id);

    void saveUserAddress(UserAddress userAddress);

    void deleteUserAddressById(String id);

    void updateUserAddress(UserAddress userAddress);
}
