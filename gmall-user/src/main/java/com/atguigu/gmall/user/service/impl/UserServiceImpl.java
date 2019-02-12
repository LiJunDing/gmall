package com.atguigu.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UserAddressMapper;
import com.atguigu.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public List<UserInfo> getUserInfoList() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void deleteUserInfoById(String id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public List<UserAddress> getuserAddressList() {
        return userAddressMapper.selectAll();
    }

    @Override
    public UserAddress getUserAddressbyId(String id) {
        return userAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveUserAddress(UserAddress userAddress) {
        userAddressMapper.insert(userAddress);
    }

    @Override
    public void deleteUserAddressById(String id) {
        userAddressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUserAddress(UserAddress userAddress) {
        userAddressMapper.updateByPrimaryKey(userAddress);
    }
}
