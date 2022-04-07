package com.feng.fbstore.service;

import com.feng.fbstore.entity.Product;
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
public interface ProductService extends IService<Product> {

    List<Product> getProducts();

    List<Product> getProducts(int i);

    Product findProductById(Long id);

    void updataStatus(Long productId);

    void updateProductById(Long editId, Product product);
}
