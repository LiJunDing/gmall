package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.SkuInfo;

import java.util.List;

public interface SkuService {

    List<SkuInfo> getSkuInfoListBySpu(String spuId);

    void saveSku(SkuInfo skuInfo);

    SkuInfo item(String skuId);

    List<SkuInfo> getSkuSaleAttrValueListBySpu(String spuId);
}
