package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping("")
    @ResponseBody
    public List<UserInfo> userInfoList() {

        List<UserInfo> userInfoList = userService.getUserInfoList();

        return userInfoList;
    }

    @RequestMapping("")
    @ResponseBody
    public UserInfo userInfo(String id) {

        UserInfo userInfo = userService.getUserInfoById(id);

        return userInfo;
    }

    @RequestMapping("")
    @ResponseBody
    public String addUserInfo(UserInfo userInfo) {

        userService.saveUserInfo(userInfo);

        return "";
    }

    @RequestMapping("")
    @ResponseBody
    public String deleteUserInfo(String id) {

        userService.deleteUserInfoById(id);

        return "";
    }

    @RequestMapping("")
    @ResponseBody
    public String updateuserInfo(UserInfo userInfo) {

        userService.updateUserInfo(userInfo);

        return "";
    }

    @RequestMapping("")
    @ResponseBody
    public List<UserAddress> userAddressList() {

        List<UserAddress> userAddressList = userService.getuserAddressList();

        return userAddressList;
    }

    @RequestMapping("")
    @ResponseBody
    public UserAddress userAddress(String id) {

        UserAddress userAddress = userService.getUserAddressbyId(id);

        return userAddress;
    }

    @RequestMapping("")
    @ResponseBody
    public String addUserAddress(UserAddress userAddress) {

        userService.saveUserAddress(userAddress);

        return "";
    }

    @RequestMapping("")
    @ResponseBody
    public String deleteUserAddress(String id) {

        userService.deleteUserAddressById(id);

        return "";
    }

    @RequestMapping("")
    @ResponseBody
    public String updateUserAddress(UserAddress userAddress) {

        userService.updateUserAddress(userAddress);

        return "";
    }
}
