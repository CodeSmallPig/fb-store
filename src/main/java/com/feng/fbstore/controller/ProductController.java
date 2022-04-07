package com.feng.fbstore.controller;


import com.feng.fbstore.entity.Product;
import com.feng.fbstore.exception.CodeException;
import com.feng.fbstore.service.FinanceService;
import com.feng.fbstore.service.ProductService;
import com.feng.fbstore.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author feng
 * @since 2022-02-22
 */
@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    FinanceService financeService;


    @PostMapping("/add")
    @Transactional
    public R addProduct(@RequestBody Product product) {
        //再次对商品进行校验
        if (product == null) {
            return R.error(CodeException.NOTFOUND_Content.getStatus(),CodeException.NOTFOUND_Content.getMsg());
        }
        productService.save(product);
        return R.ok("商品内容新增成功");
    }

    @PostMapping("/update/{editId}")
    @Transactional
    public R updateProduct(@PathVariable("editId") Long editId,@RequestBody Product product) {
        //再次对商品进行校验
        if (product == null) {
            return R.error(CodeException.NOTFOUND_Content.getStatus(),CodeException.NOTFOUND_Content.getMsg());
        }
        productService.updateProductById(editId,product);
        return R.ok("内容商品更新成功！");
    }


    @RequestMapping("/info/{id}")
    public R findProductById(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        //判断此时商品是否已经售出，如果已经售出，则将售出的数量返回前端
        if (product.getStatus() == 1) {
            //说明已经售出，从财务表中查询该商品售出的数量
            Integer number = financeService.findNumbersByProductId(id);
            return R.ok("内容商品信息获取成功").put("product",product).put("number",number);
        }
        return R.ok("内容商品信息获取成功").put("product",product);
    }


}

