package com.gyhl.test.mapper;

import com.gyhl.test.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2020-03-13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
	public List<User> getUserlList();
}
