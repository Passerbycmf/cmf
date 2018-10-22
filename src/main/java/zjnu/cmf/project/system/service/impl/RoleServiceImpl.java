package zjnu.cmf.project.system.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.common.constant.UserConstants;
import zjnu.cmf.common.utils.ShiroUtils;
import zjnu.cmf.common.utils.StringUtils;
import zjnu.cmf.project.system.bean.RoleMenu;
import zjnu.cmf.project.system.mapper.RoleMapper;
import zjnu.cmf.project.system.bean.Role;
import zjnu.cmf.project.system.mapper.RoleMenuMapper;
import zjnu.cmf.project.system.mapper.UserRoleMapper;
import zjnu.cmf.project.system.service.IRoleService;
import zjnu.cmf.common.utils.Convert;

/**
 * 角色 服务层实现
 * 
 * @author cmf
 * @date 2018-10-09
 */
@Service
public class RoleServiceImpl implements IRoleService 
{
	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
     * 查询角色信息
     * 
     * @param roleId 角色ID
     * @return 角色信息
     */
    @Override
	public Role selectRoleById(Integer roleId)
	{
	    return roleMapper.selectRoleById(roleId);
	}
	
	/**
     * 查询角色列表
     * 
     * @param role 角色信息
     * @return 角色集合
     */
	@Override
	public List<Role> selectRoleList(Role role)
	{
	    return roleMapper.selectRoleList(role);
	}
	
    /**
     * 新增角色
     * 
     * @param role 角色信息
     * @return 结果
     */
	@Override
	public int insertRole(Role role)
	{
		role.setCreateBy(ShiroUtils.getLoginName());
		// 新增角色信息
		roleMapper.insertRole(role);
		ShiroUtils.clearCachedAuthorizationInfo();
		return insertRoleMenu(role);

	}

	/**
	 * 新增角色菜单信息
	 *
	 * @param role 角色对象
	 */
	public int insertRoleMenu(Role role)
	{
		int rows = 1;
		// 新增用户与角色管理
		List<RoleMenu> list = new ArrayList<RoleMenu>();
		for (Integer menuId : role.getMenuIds())
		{
			RoleMenu rm = new RoleMenu();
			rm.setRoleId(role.getRoleId());
			rm.setMenuId(menuId);
			list.add(rm);
		}
		if (list.size() > 0)
		{
			rows = roleMenuMapper.batchRoleMenu(list);
		}
		return rows;
	}

	/**
     * 修改角色
     * 
     * @param role 角色信息
     * @return 结果
     */
	@Override
	public int updateRole(Role role)
	{
		role.setUpdateBy(ShiroUtils.getLoginName());
		// 修改角色信息
		roleMapper.updateRole(role);
		// 删除角色与菜单关联
		roleMenuMapper.deleteRoleMenuByRoleId(role.getRoleId());
		ShiroUtils.clearCachedAuthorizationInfo();
		return insertRoleMenu(role);

	}

	/**
	 * 通过角色ID删除角色
	 *
	 * @param roleId 角色ID
	 * @return 结果
	 */
	@Override
	public boolean deleteRoleById(Integer roleId)
	{
		return roleMapper.deleteRoleById(roleId) > 0 ? true : false;
	}

	/**
	 * 批量删除角色信息
	 *
	 * @param ids 需要删除的数据ID
	 * @throws Exception
	 */
	@Override
	public int deleteRoleByIds(String ids) throws Exception
	{
		Integer[] roleIds = Convert.toLongArray(ids);
		for (Integer roleId : roleIds)
		{
			Role role = selectRoleById(roleId);
			if (countUserRoleByRoleId(roleId) > 0)
			{
				throw new Exception(String.format("%1$s已分配,不能删除", role.getRoleName()));
			}
		}
		return roleMapper.deleteRoleByIds(roleIds);
	}



	/**
	 * 校验角色名称是否唯一
	 * @param role 角色信息
	 * @return
	 */
	@Override
	public String checkRoleNameUnique(Role role) {
		Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        Role info = roleMapper.checkRoleNameUnique(role.getRoleName());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue()){
        	return UserConstants.ROLE_KEY_NOT_UNIQUE;
		}
		return UserConstants.ROLE_KEY_UNIQUE;
	}

	/**
	 * 校验角色权限是否唯一
	 * @param role 角色信息
	 * @return
	 */
	@Override
	public String checkRoleKeyUnique(Role role) {
		Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
		Role info = roleMapper.checkRoleKeyUnique(role.getRoleKey());
		if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue()){
			return UserConstants.ROLE_KEY_NOT_UNIQUE;
		}
		return UserConstants.ROLE_KEY_UNIQUE;
	}

	/**
	 * 查询所有角色
	 * @return 角色列表
	 */
	@Override
	public List<Role> selectRoleAll() {
		return roleMapper.selectRolesAll();
	}

	/**
	 * 根据用户ID查询角色
	 * @param userId 用户ID
	 * @return 角色列表
	 */
	@Override
	public List<Role> selectRolesByUserId(Integer userId) {
		List<Role> userRoles = roleMapper.selectRolesByUserId(userId);
		List<Role> roles = roleMapper.selectRolesAll();
		for (Role role : roles){
			for (Role userRole : userRoles){
				if (role.getRoleId().longValue()==userRole.getRoleId().longValue()){
					role.setFlag(true);
					break;
				}
			}
		}
		return roles;
	}

	/**
	 * 通过角色ID查询角色使用数量
	 *
	 * @param roleId 角色ID
	 * @return 结果
	 */
	@Override
	public int countUserRoleByRoleId(Integer roleId)
	{
		return userRoleMapper.countUserRoleByRoleId(roleId);
	}

	/**
	 * 根据用户ID查询权限
	 *
	 * @param userId 用户ID
	 * @return 权限列表
	 */
	@Override
	public Set<String> selectRoleKeys(Integer userId)
	{
		List<Role> perms = roleMapper.selectRolesByUserId(userId);
		Set<String> permsSet = new HashSet<>();
		for (Role perm : perms)
		{
			if (StringUtils.isNotNull(perms))
			{
				permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
			}
		}
		return permsSet;
	}


}
