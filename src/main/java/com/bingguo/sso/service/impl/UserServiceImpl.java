package com.bingguo.sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingguo.sso.domain.User;
import com.bingguo.sso.mapper.UserMapper;
import com.bingguo.sso.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;

	@Override
	public User selectByUsername(String username) {
		return userMapper.selectByUsername(username);
	}
	
}
