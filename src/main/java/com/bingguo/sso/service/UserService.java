package com.bingguo.sso.service;

import com.bingguo.sso.domain.User;

public interface UserService {
	User selectByUsername(String username);
}
