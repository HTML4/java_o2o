package com.imooc.o2o.dao;

import com.imooc.o2o.entity.ProductImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductImgDao {
    List<ProductImg> queryProductImgByProductId(long productId);
    /**
     * 批量插入商品图片
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(@Param("productImgList") List<ProductImg> productImgList);

    /**
     * 删除指定商品下的所有详情图
     * @param productId
     * @return
     */
    int deleteProductImg(long productId);
}
