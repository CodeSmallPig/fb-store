package com.feng.fbstore.service.impl;

import com.feng.fbstore.entity.Finance;
import com.feng.fbstore.mapper.FinanceMapper;
import com.feng.fbstore.service.FinanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class FinanceServiceImpl extends ServiceImpl<FinanceMapper, Finance> implements FinanceService {
    @Autowired
    FinanceMapper financeMapper;

    @Override
    public List<Finance> getFinances() {
        List<Finance> financeList = financeMapper.selectList(null);
        return financeList;
    }

    @Override
    public Integer findNumbersByProductId(Long id) {
        Integer number = financeMapper.findNumbersByProductId(id);
        return number;
    }
}
