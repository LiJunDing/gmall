package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseAttrValue;
import com.atguigu.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AttrController {

    @Reference
    AttrService attrService;

    @RequestMapping("getAttrList")
    @ResponseBody
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {
        return attrService.getAttrList(catalog3Id);
    }

    @RequestMapping("saveAttr")
    @ResponseBody
    public String saveAttr(BaseAttrInfo baseAttrInfo) {

        attrService.saveAttr(baseAttrInfo);

        return "SUCCESS";
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<BaseAttrValue> getAttrValueList(BaseAttrValue baseAttrValue) {
        return attrService.getAttrValueList(baseAttrValue);
    }

    @RequestMapping("deleteAttr")
    @ResponseBody
    public String deleteAttr(BaseAttrInfo baseAttrInfo) {

        attrService.deleteAttr(baseAttrInfo);

        return "SUCCESS";
    }
}
