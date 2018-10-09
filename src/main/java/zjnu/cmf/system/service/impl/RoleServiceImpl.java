package zjnu.cmf.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.system.mapper.RoleMapper;
import zjnu.cmf.system.bean.Role;
import zjnu.cmf.system.service.IRoleService;
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
	    return roleMapper.insertRole(role);
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
	    return roleMapper.updateRole(role);
	}

	/**
     * 删除角色对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRoleByIds(String ids)
	{
		return roleMapper.deleteRoleByIds(Convert.toStrArray(ids));
	}
	
}
