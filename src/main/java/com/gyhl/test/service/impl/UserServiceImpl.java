package com.gyhl.test.service.impl;

import com.gyhl.test.entity.User;
import com.gyhl.test.mapper.UserMapper;
import com.gyhl.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yang
 * @since 2020-03-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
