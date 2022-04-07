package com.feng.fbstore.controller;


import com.feng.fbstore.entity.Finance;
import com.feng.fbstore.exception.CodeException;
import com.feng.fbstore.service.FinanceService;
import com.feng.fbstore.vo.CartVo;
import com.feng.fbstore.entity.Cart;
import com.feng.fbstore.entity.Product;
import com.feng.fbstore.service.CartService;
import com.feng.fbstore.service.ProductService;
import com.feng.fbstore.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    FinanceService financeService;

    @PostMapping("/add")
    @Transactional
    public R addCart(@RequestBody Cart cart) {
        Cart cartFind = cartService.findCartByProductId(cart.getProductId());
        //如果该cart中的商品id已经存在于购物车中，则选择更新购物车表的该条信息
        if (cartFind != null) {
            cartFind.setNumber(cart.getNumber() + cartFind.getNumber());
            cartService.updateById(cartFind);
        }else {
            //如果不存在，则直接添加
            cartService.save(cart);
        }
        return R.ok("内容商品添加购物车成功！");
    }

    @GetMapping("/list")
    public R getCarts() {
        List<Cart> carts = cartService.getCarts();
        List<CartVo> cartVos = new ArrayList<>();
        for (Cart cart : carts) {
            CartVo cartVo = new CartVo();
            BeanUtils.copyProperties(cart,cartVo);
            Product product = productService.findProductById(cart.getProductId());
            cartVo.setTitle(product.getTitle());
            cartVo.setPicture(product.getPicture());
            cartVo.setPrice(product.getPrice());
            cartVos.add(cartVo);
        }
        return R.ok("成功获取购物车信息！").put("carts",cartVos);
    }

    @Transactional
    @PostMapping("/submit")
    public R submitCarts(@RequestBody List<CartVo> cartVos) {
        //将所有购物车内容进行结算，存储到财务表中
        if (cartVos.size() > 0) {
            for (CartVo cartVo : cartVos) {
                Finance finance = new Finance();
                finance.setProductId(cartVo.getProductId());
                finance.setNumber(cartVo.getNumber());
                financeService.save(finance);
                //将内容商品设置为已购买
                productService.updataStatus(cartVo.getProductId());
                //将该购物车记录删除
                cartService.removeById(cartVo.getId());
            }
            return R.ok("购物车清算成功").put("msg","购物车结算成功");
        }else {
            return R.error(CodeException.NOTEXISTED_Cart.getStatus(),CodeException.NOTEXISTED_Cart.getMsg());
        }


    }



}

