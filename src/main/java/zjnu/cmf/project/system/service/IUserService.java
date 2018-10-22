package zjnu.cmf.project.system.service;


import zjnu.cmf.project.system.bean.User;

import java.util.List;

/**
 * 用户 服务层
 * 
 * @author cmf
 * @date 2018-08-12
 */
public interface IUserService 
{
	/**
     * 查询用户信息
     * 
     * @param userId 用户ID
     * @return 用户信息
     */
	public User selectUserById(Integer userId);
	
	/**
     * 查询用户列表
     * 
     * @param user 用户信息
     * @return 用户集合
     */
	public List<User> selectUserList(User user);
	
	/**
     * 新增用户
     * 
     * @param user 用户信息
     * @return 结果
     */
	public int insertUser(User user);
	
	/**
     * 修改用户
     * 
     * @param user 用户信息
     * @return 结果
     */
	public int updateUser(User user);

	/**
	 * 通过用户ID删除用户
	 *
	 * @param userId 用户ID
	 * @return 结果
	 */
	public int deleteUserById(Integer userId);

	/**
	 * 批量删除用户信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 * @throws Exception 异常
	 */
	public int deleteUserByIds(String ids) throws Exception;

	/**
	 * 修改用户密码信息
	 * @param user
	 * @return 结果
	 */
    int resetUserPwd(User user);

	/**
	 * 校验用户名称是否唯一
	 * @param loginName 登录名称
	 * @return
	 */
	String checkLoginNameUnique(String loginName);

	/**
	 * 校验手机号码是否唯一
	 * @param user 用户信息
	 * @return
	 */
	String checkPhoneUnique(User user);

	/**
	 * 校验email是否唯一
	 * @param user 用户信息
	 * @return
	 */
	String checkEmailUnique(User user);

	/**
	 * 根据用户ID查询用户所属角色组
	 *
	 * @param userId 用户ID
	 * @return 结果
	 */
	 String selectUserRoleGroup(Integer userId);


	/**
	 * 通过用户名查询用户
	 *
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	 User selectUserByLoginName(String userName);

	/**
	 * 通过手机号码查询用户
	 *
	 * @param phoneNumber 手机号码
	 * @return 用户对象信息
	 */
	 User selectUserByPhoneNumber(String phoneNumber);

	/**
	 * 通过邮箱查询用户
	 *
	 * @param email 邮箱
	 * @return 用户对象信息
	 */
	 User selectUserByEmail(String email);

	/**
	 * 修改用户详细信息
	 *
	 * @param user 用户信息
	 * @return 结果
	 */
	 int updateUserInfo(User user);

	/**
	 * 根据用户ID查询用户所属岗位组
	 *
	 * @param userId 用户ID
	 * @return 结果
	 */
	 String selectUserPostGroup(Integer userId);



}
