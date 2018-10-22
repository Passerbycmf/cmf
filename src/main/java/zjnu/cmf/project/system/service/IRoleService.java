package zjnu.cmf.project.system.service;

import zjnu.cmf.project.system.bean.Role;
import java.util.List;
import java.util.Set;

/**
 * 角色 服务层
 * 
 * @author cmf
 * @date 2018-10-09
 */
public interface IRoleService 
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
	 * 通过角色ID删除角色
	 *
	 * @param roleId 角色ID
	 * @return 结果
	 */
	public boolean deleteRoleById(Integer roleId);

	/**
	 * 批量删除角色用户信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 * @throws Exception 异常
	 */
	public int deleteRoleByIds(String ids) throws Exception;

	/**
	 * 校验角色名称是否唯一
	 * @param role 角色信息
	 * @return
	 */
    String checkRoleNameUnique(Role role);

	/**
	 * 校验角色权限是否唯一
	 * @param role
	 * @return
	 */
	String checkRoleKeyUnique(Role role);

	/**
	 * 查询所有角色
	 * @return 角色列表
	 */
    List<Role> selectRoleAll();

	/**
	 * 根据用户ID查询角色
	 * @param userId 用户ID
	 * @return 用户角色
	 */
	List<Role> selectRolesByUserId(Integer userId);

	/**
	 * 通过角色ID查询角色使用数量
	 *
	 * @param roleId 角色ID
	 * @return 结果
	 */
	int countUserRoleByRoleId(Integer roleId);

	/**
	 * 根据用户ID查询角色
	 *
	 * @param userId 用户ID
	 * @return 权限列表
	 */
	 Set<String> selectRoleKeys(Integer userId);
}
