package com.rz51.common.dao;

import java.util.List;
import java.util.Set;

import com.rz51.permission.enti.UPermissionExt;

public interface UPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(com.rz51.common.model.UPermission record);

    int insertSelective(com.rz51.common.model.UPermission record);

    com.rz51.common.model.UPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(com.rz51.common.model.UPermission record);

    int updateByPrimaryKey(com.rz51.common.model.UPermission record);

	List<UPermissionExt> selectPermissionById(Long id);
	//根据用户ID获取权限的Set集合
	Set<String> findPermissionByUserId(Long id);
}