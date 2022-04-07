package com.feng.fbstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.fbstore.entity.Product;
import com.feng.fbstore.mapper.ProductMapper;
import com.feng.fbstore.service.ProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getProducts() {
        List<Product> products = productMapper.selectList(null);
        return products;
    }

    @Override
    public List<Product> getProducts(int i) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",0);
        List<Product> products = productMapper.selectList(queryWrapper);
        return products;
    }

    @Override
    public Product findProductById(Long id) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<Product>().eq("id", id);
        Product product = productMapper.selectOne(queryWrapper);
        return product;
    }

    @Override
    @Transactional
    public void updataStatus(Long productId) {
        productMapper.updateStatus(productId);

    }

    @Override
    public void updateProductById(Long editId, Product product) {
        productMapper.updateProductById(product.getTitle(),product.getAbs(),product.getContent(),product.getPicture(),
                product.getPrice(),editId);
    }
}
