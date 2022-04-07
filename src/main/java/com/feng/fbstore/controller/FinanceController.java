package com.feng.fbstore.controller;


import com.feng.fbstore.entity.Finance;
import com.feng.fbstore.entity.Product;
import com.feng.fbstore.service.FinanceService;
import com.feng.fbstore.service.ProductService;
import com.feng.fbstore.utils.R;
import com.feng.fbstore.vo.FinanceVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/finance")
public class FinanceController {
    @Autowired
    FinanceService financeService;

    @Autowired
    ProductService productService;


    @GetMapping("/list")
    public R getFinances() {
        List<Finance> financeList =  financeService.getFinances();
        List<FinanceVo> finances = new ArrayList<>();
        BigDecimal total = new BigDecimal(0);
        for (Finance finance : financeList) {
            //创建FinanceVo视图对象，将finance和对应product的信息拷贝其中
            FinanceVo financeVo = new FinanceVo();
            BeanUtils.copyProperties(finance,financeVo);
            Product product = productService.findProductById(finance.getProductId());
            financeVo.setTitle(product.getTitle());
            financeVo.setPicture(product.getPicture());
            financeVo.setPrice(product.getPrice());
            finances.add(financeVo);
            //统计总金额
            total = total.add(product.getPrice().multiply(new BigDecimal(finance.getNumber().toString())));
        }
        return R.ok("成功获取财务清单！").put("finances",finances).put("totalAccount",total);
    }

}

