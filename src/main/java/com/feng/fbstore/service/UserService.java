package com.feng.fbstore.service;

import com.feng.fbstore.entity.User;
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
public interface UserService extends IService<User> {

    User findUser(String username, String password);
}
