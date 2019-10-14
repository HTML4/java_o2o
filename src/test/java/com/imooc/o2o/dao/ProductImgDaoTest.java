package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.ProductImg;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testBQueryByProductId() {
        long productId = 1;
        List<ProductImg> productImgList = productImgDao.queryProductImgByProductId(productId);
        System.out.println("商品图片数："+ productImgList.size());
    }
    @Test
    public void tesABatchInsetProductImg() throws Exception{
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(1L);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(1L);
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effectedNum = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2, effectedNum);
    }
    @Test
    public void testCDeleteProductImg(){
        long productId = 1;
        List<ProductImg> productImgList = productImgDao.queryProductImgByProductId(productId);
        for (ProductImg pi: productImgList) {
            if("图片1".equals(pi.getImgAddr()) || "图片2".equals(pi.getImgAddr())) {
                int rowCount = productImgDao.deleteProductImg(productId);
                assertEquals(1, rowCount);
            }
        }

    }
}
