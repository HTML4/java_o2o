package com.imooc.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin", method = {RequestMethod.GET})
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        //转发至店铺注册/编辑
        return "shop/shopoperation";
    }
    @RequestMapping(value = "/shoplist")
    public String shopList(){
        //转发至店铺列表页面
        return "shop/shoplist";
    }
    @RequestMapping(value = "/shopmanagement")
    public String shopManagement(){
        //转发至店铺管理页面
        return "shop/shopmanagement";
    }
    @RequestMapping(value = "/productcategorymanage")
    public String productCategoryManagement(){
        //转发至商品类别管理页面
        return "shop/productcategorymanage";
    }

    @RequestMapping(value = "/productmanage")
    public String productManagement(){
        return "shop/productmanage";
    }
    @RequestMapping(value = "/productedit")
    public String productEdit(){
        return "shop/productedit";
    }
}
