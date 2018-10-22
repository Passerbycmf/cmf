package zjnu.cmf.project.system.mapper;

import zjnu.cmf.project.system.bean.Role;
import java.util.List;	

/**
 * 角色 数据层
 * 
 * @author cmf
 * @date 2018-10-09
 */
public interface RoleMapper 
{
	/**
     * 查询角色信息
     * 
     * @param roleId 角色ID
     * @return 角色信息
     */
	public Role selectRoleById(Integer roleId);
	
	/**
     * 查询角色列表
     * 
     * @param role 角色信息
     * @return 角色集合
     */
	public List<Role> selectRoleList(Role role);
	
	/**
     * 新增角色
     * 
     * @param role 角色信息
     * @return 结果
     */
	public int insertRole(Role role);
	
	/**
     * 修改角色
     * 
     * @param role 角色信息
     * @return 结果
     */
	public int updateRole(Role role);
	
	/**
     * 删除角色
     * 
     * @param roleId 角色ID
     * @return 结果
     */
	public int deleteRoleById(Integer roleId);
	
	/**
     * 批量删除角色
     * 
     * @param roleIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteRoleByIds(Integer[] roleIds);

	/**
	 * 校验角色名称是否唯一
	 * @param roleName 角色名称
	 * @return
	 */
    Role checkRoleNameUnique(String roleName);

	/**
	 * 校验角色权限是否唯一
	 * @param roleKey
	 * @return
	 */
	Role checkRoleKeyUnique(String roleKey);

	/**
	 * 查询角色列表
	 * @return 角色列表
	 */
    List<Role> selectRolesAll();

	/**
	 * 根据用户ID查询角色
	 * @param userId 用户ID
	 * @return 角色列表
	 */
	List<Role> selectRolesByUserId(Integer userId);
}