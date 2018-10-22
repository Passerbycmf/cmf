package zjnu.cmf.project.monitor.service;

import zjnu.cmf.project.monitor.bean.UserOnline;

import java.util.Date;
import java.util.List;

/**
 * 在线用户记录 服务层
 * 
 * @author cmf
 * @date 2018-10-11
 */
public interface IUserOnlineService 
{
	/**
     * 查询在线用户记录信息
     * 
     * @param sessionId 在线用户记录ID
     * @return 在线用户记录信息
     */
	public UserOnline selectUserOnlineById(String sessionId);
	
	/**
     * 查询在线用户记录列表
     * 
     * @param userOnline 在线用户记录信息
     * @return 在线用户记录集合
     */
	public List<UserOnline> selectUserOnlineList(UserOnline userOnline);
	
	/**
     * 新增在线用户记录
     * 
     * @param userOnline 在线用户记录信息
     * @return 结果
     */
	public int insertUserOnline(UserOnline userOnline);
	
	/**
     * 修改在线用户记录
     * 
     * @param userOnline 在线用户记录信息
     * @return 结果
     */
	public int updateUserOnline(UserOnline userOnline);
		
	/**
     * 删除在线用户记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserOnlineByIds(String ids);

	/**
	 * 通过会话序号查询信息
	 *
	 * @param sessionId 会话ID
	 * @return 在线用户信息
	 */
	 UserOnline selectOnlineById(String sessionId);

	/**
	 * 保存会话信息
	 *
	 * @param online 会话信息
	 */
	 void saveOnline(UserOnline online);

	/**
	 * 通过会话序号删除信息
	 *
	 * @param sessionId 会话ID
	 * @return 在线用户信息
	 */
	void deleteOnlineById(String sessionId);

	/**
	 * 查询会话集合
	 *
	 * @param expiredDate 有效期
	 * @return 会话集合
	 */
	 List<UserOnline> selectOnlineByExpired(Date expiredDate);

	/**
	 * 通过会话序号删除信息
	 *
	 * @param sessions 会话ID集合
	 * @return 在线用户信息
	 */
	 void batchDeleteOnline(List<String> sessions);

	/**
	 * 强退用户
	 *
	 * @param sessionId 会话ID
	 */
	 void forceLogout(String sessionId);

}
