package com.feng.fbstore.mapper;

import com.feng.fbstore.entity.Finance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author feng
 * @since 2022-02-22
 */
public interface FinanceMapper extends BaseMapper<Finance> {


    @Select("select number from fb_finance where product_id = #{id}")
    Integer findNumbersByProductId(Long id);

}
