package com.imooc.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/frontend")
public class FrontendController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "frontend/index";
    }
    @RequestMapping(value = "/shoplist", method = RequestMethod.GET)
    public String shopList(){
        return "frontend/shoplist";
    }
}
