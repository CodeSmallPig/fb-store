package com.feng.fbstore.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by FengBin on 2022/2/26 10:26
 */
@Data
public class CartVo {
    private Long id;

    private Long productId;

    private Integer number;

    private String title;

    private String picture;

    private BigDecimal price;
}
