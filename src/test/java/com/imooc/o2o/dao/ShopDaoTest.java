package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testQueryShopList(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
        int count =shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表："+shopList.size());
        System.out.println("店铺总数："+count);
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(3L);
        shopCondition.setShopCategory(sc);
        shopList = shopDao.queryShopList(shopCondition, 0, 2);
        System.out.println("xxx店铺列表："+shopList.size());
        count =shopDao.queryShopCount(shopCondition);
        System.out.println("xxx店铺总数："+count);
    }
    @Test
    @Ignore
    public void testQueryByShopId(){
        Shop shop = shopDao.queryByShopId(1L);
        System.out.println("area_id:" + shop.getArea().getAreaId());
        System.out.println("area_name:" + shop.getArea().getAreaName());
    }
    @Test
    @Ignore     //不执行
    public void testInsertShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("渣渣店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setAdvice("审核中");
        shop.setEnableStatus(1);
        int rowCount = shopDao.insertShop(shop);
        assertEquals(1, rowCount);
    }
    @Test
    @Ignore
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int rowCount = shopDao.updateShop(shop);
        assertEquals(1, rowCount);
    }
}
