package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.dc.pr.PRError;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao productDao;
    @Test
    public void testinsertProduct(){
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        product.setShop(shop);
        product.setProductName("测试");
        product.setProductDesc("测试内容");
        product.setEnableStatus(1);
        product.setPromotionPrice("1.1");
        product.setNormalPrice("1");
        product.setCreateTime(new Date());
        product.setPriority(1);
        int rowCount = productDao.insertProduct(product);
        assertEquals(1, rowCount);
    }
}
