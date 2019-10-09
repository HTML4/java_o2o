package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import static org.junit.Assert.assertEquals;

/**
 * Created by jason on 2019/9/10.
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
	public void testGetShopList(){
		Shop shopCondition = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(3L);
		shopCondition.setShopCategory(sc);
		ShopExecution se = shopService.getShopList(shopCondition, 0, 2);
		System.out.println("店铺列表数为：" +  se.getShopList().size());
	}
    @Test
	@Ignore
	public void testModifyShop() throws ShopOperationException, FileNotFoundException{
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopName("修改后的店铺名称");
		File shopImg = new File("D:\\code\\hcredits-frontend\\build\\images\\banner.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder("banner.jpg",is);
		ShopExecution se = shopService.modifyShop(shop, imageHolder);
		System.out.println("修改后的图片：" + se.getShop().getShopImg());
	}
    @Test
	@Ignore
    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
		Area area = new Area();
        owner.setUserId(1L);
		area.setAreaId(2);
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
		shop.setShopName("mytest2");
		shop.setShopDesc("mytest2");
		shop.setShopAddr("testaddr2");
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
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder(shopImg.getName(),is);
        ShopExecution se = shopService.addShop(shop, imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}
