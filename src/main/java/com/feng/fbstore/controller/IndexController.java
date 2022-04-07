package com.feng.fbstore.controller;

import com.feng.fbstore.entity.Product;
import com.feng.fbstore.service.ProductService;
import com.feng.fbstore.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by FengBin on 2022/2/24 12:48
 */
@RestController
@CrossOrigin
public class IndexController {

    @Autowired
    ProductService productService;

    /*获取所有内容列表信息*/
    @RequestMapping("/index")
    public R getProducts() {
        List<Product> products = productService.getProducts();
        return R.ok("成功获取内容商品列表").put("products",products);
    }

    @RequestMapping("/index/type")
    public R getProductByType(@RequestParam String type) {
        List<Product> products = null;
        if (type.equals("allContent")) {
            products = productService.getProducts();
        }else if (type.equals("no-buy")) {
            products = productService.getProducts(0);
        }
        return R.ok("成功获取内容商品列表").put("products",products);
    }

}
