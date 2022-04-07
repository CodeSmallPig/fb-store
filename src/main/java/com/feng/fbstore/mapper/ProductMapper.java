package com.feng.fbstore.mapper;

import com.feng.fbstore.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author feng
 * @since 2022-02-22
 */
public interface ProductMapper extends BaseMapper<Product> {

    @Update("update fb_product p set p.status = 1 where p.id = #{productId}")
    Integer updateStatus(Long productId);


    @Update("update fb_product set title = #{title}, abs = #{abs}, content = #{content}, picture = #{picture}, price = #{price} where id = #{editId};")
    Integer updateProductById(String title, String abs, String content,
                              String picture, BigDecimal price, Long editId);

}
