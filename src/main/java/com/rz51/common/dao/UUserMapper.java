package com.rz51.common.dao;

import java.util.List;
import java.util.Map;

import com.rz51.common.model.UUser;
import com.rz51.permission.enti.URoleExt;

public interface UUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UUser record);

    int insertSelective(UUser record);

    UUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUser record);

    int updateByPrimaryKey(UUser record);

    UUser login(Map<String, Object> map);

    UUser findUserByEmail(String email);

    List<URoleExt> selectRoleByUserId(Long id);

    UUser findUserByClientId(String clientId);

}