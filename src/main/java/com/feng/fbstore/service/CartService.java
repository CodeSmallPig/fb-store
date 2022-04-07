package com.feng.fbstore.service;

import com.feng.fbstore.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2022-02-22
 */
public interface CartService extends IService<Cart> {

    List<Cart> getCarts();

    Cart findCartByProductId(Long productId);

}
