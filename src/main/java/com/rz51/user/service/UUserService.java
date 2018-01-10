package com.rz51.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.rz51.common.model.UUser;
import com.rz51.core.mybatis.page.Pagination;
import com.rz51.permission.enti.URoleExt;
import com.rz51.permission.enti.UserRoleAllocationExt;

public interface UUserService {

	int deleteByPrimaryKey(Long id);

	UUser insert(UUser record);

    UUser insertSelective(UUser record);

    UUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUser record);

    int updateByPrimaryKey(UUser record);
    
    UUser login(String email ,String pswd);

	UUser findUserByEmail(String email);

	Pagination<UUser> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);

	Map<String, Object> deleteUserById(String ids);

	Map<String, Object> updateForbidUserById(Long id, Long status);

	Pagination<UserRoleAllocationExt> findUserAndRole(ModelMap modelMap,
													  Integer pageNo, Integer pageSize);

	List<URoleExt> selectRoleByUserId(Long id);

	Map<String, Object> addRole2User(Long userId, String ids);

	Map<String, Object> deleteRoleByUserIds(String userIds);

	UUser findUserByClientId(String clientId);
}
