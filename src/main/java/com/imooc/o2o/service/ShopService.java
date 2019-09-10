package com.imooc.o2o.service;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;

import java.io.File;

/**
 * Created by jason on 2019/9/10.
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, File shopImg);
}
