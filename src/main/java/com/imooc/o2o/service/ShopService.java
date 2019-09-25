package com.imooc.o2o.service;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopOperationException;

import java.io.File;
import java.io.InputStream;

/**
 * Created by jason on 2019/9/10.
 */
public interface ShopService {
    /**
     * 根据shopcondition分页返回相应数据
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
     ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
    /**
     * 通过店铺id获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
