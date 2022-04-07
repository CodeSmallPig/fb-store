package com.feng.fbstore.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by FengBin on 2022/2/26 20:36
 */
@Data
public class FinanceVo {
    private Long id;

    private Long productId;

    private String title;

    private String picture;

    private BigDecimal price;

    private Integer number;

//    对日期进行格式化处理
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

}
