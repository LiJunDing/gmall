package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseAttrValue;
import com.atguigu.gmall.manage.mapper.AttrInfoMapper;
import com.atguigu.gmall.manage.mapper.AttrValueMapper;
import com.atguigu.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    AttrInfoMapper attrInfoMapper;

    @Autowired
    AttrValueMapper attrValueMapper;

    @Override
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {

        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();

        baseAttrInfo.setCatalog3Id(catalog3Id);

        List<BaseAttrInfo> attrInfos = attrInfoMapper.select(baseAttrInfo);

        for (BaseAttrInfo attrInfo : attrInfos) {

            BaseAttrValue baseAttrValue = new BaseAttrValue();

            baseAttrValue.setAttrId(attrInfo.getId());

            List<BaseAttrValue> baseAttrValues = attrValueMapper.select(baseAttrValue);

            attrInfo.setAttrValueList(baseAttrValues);
        }

        return attrInfos;
    }

    @Override
    public void saveAttr(BaseAttrInfo baseAttrInfo) {

        BaseAttrInfo baseAttrInfo1 = attrInfoMapper.selectOne(baseAttrInfo);

        if(baseAttrInfo1 != null) {
            String attrId = baseAttrInfo1.getId();
            BaseAttrValue baseAttrValue1 = new BaseAttrValue();
            baseAttrValue1.setAttrId(attrId);
            attrValueMapper.delete(baseAttrValue1);
            BaseAttrInfo baseAttrInfo2 = new BaseAttrInfo();
            baseAttrInfo2.setId(attrId);
            attrInfoMapper.delete(baseAttrInfo2);
        }

        baseAttrInfo.setIsEnabled("1");

        attrInfoMapper.insertSelective(baseAttrInfo);

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();

        for (BaseAttrValue baseAttrValue : attrValueList) {
            baseAttrValue.setAttrId(baseAttrInfo.getId());
            attrValueMapper.insertSelective(baseAttrValue);
        }

    }

    @Override
    public List<BaseAttrValue> getAttrValueList(BaseAttrValue baseAttrValue) {
        return attrValueMapper.select(baseAttrValue);
    }

    @Override
    public void deleteAttr(BaseAttrInfo baseAttrInfo) {

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue baseAttrValue : attrValueList) {
            attrValueMapper.delete(baseAttrValue);
        }

        attrInfoMapper.delete(baseAttrInfo);
    }
}
