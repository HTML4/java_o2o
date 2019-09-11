package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;
import static org.junit.Assert.assertEquals;

/**
 * Created by jason on 2019/9/10.
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
		Area area = new Area();
        owner.setUserId(1L);
		area.setAreaId(2);
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		//shop.setShopImg("test1");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		//D:\code\hcredits-frontend\build\images\b1.553c69e9.jpg
		File shopImg = new File("/Users/jason/Downloads/fced2360ecef903460f25be013ab25cc_2_3_art.png");
        ShopExecution se = shopService.addShop(shop, shopImg);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}
