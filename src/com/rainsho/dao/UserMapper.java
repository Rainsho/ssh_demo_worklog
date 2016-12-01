package com.rainsho.dao;

import org.springframework.stereotype.Repository;

import com.rainsho.entity.User;

@Repository
public interface UserMapper {
	int deleteByPrimaryKey(Integer uid);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectByUsername(String username);
}