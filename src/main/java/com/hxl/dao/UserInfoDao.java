package com.hxl.dao;

import com.hxl.domain.UserInfo;

import java.util.List;


/**
 * 持久层接口
 */
public interface UserInfoDao {

    List<UserInfo> findAll();
}


