package com.feng.fbstore.service;

import com.feng.fbstore.entity.Finance;
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
public interface FinanceService extends IService<Finance> {

    List<Finance> getFinances();

    Integer findNumbersByProductId(Long id);
}
