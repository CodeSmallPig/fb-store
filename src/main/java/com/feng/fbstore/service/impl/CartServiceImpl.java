package com.feng.fbstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.feng.fbstore.entity.Cart;
import com.feng.fbstore.mapper.CartMapper;
import com.feng.fbstore.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feng
 * @since 2022-02-22
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> getCarts() {
        List<Cart> carts = cartMapper.selectList(null);
        return carts;
    }

    @Override
    public Cart findCartByProductId(Long productId) {
        Cart cartFind = cartMapper.selectOne(new QueryWrapper<Cart>().eq("product_id", productId));
        System.out.println("1111");
        return cartFind;
    }
}
