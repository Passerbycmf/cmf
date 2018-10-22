package zjnu.cmf.project.monitor.mapper;

import zjnu.cmf.project.monitor.bean.UserOnline;
import java.util.List;	

/**
 * 在线用户记录 数据层
 * 
 * @author cmf
 * @date 2018-10-11
 */
public interface UserOnlineMapper 
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
     * 删除在线用户记录
     * 
     * @param sessionId 在线用户记录ID
     * @return 结果
     */
	public int deleteUserOnlineById(String sessionId);
	
	/**
     * 批量删除在线用户记录
     * 
     * @param sessionIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserOnlineByIds(String[] sessionIds);

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
	 * @return 结果
	 */
	 int saveOnline(UserOnline online);

	/**
	 * 通过会话序号删除信息
	 *
	 * @param sessionId 会话ID
	 * @return 在线用户信息
	 */
	 int deleteOnlineById(String sessionId);

	/**
	 * 查询过期会话集合
	 *
	 * @param lastAccessTime 过期时间
	 * @return 会话集合
	 */
	 List<UserOnline> selectOnlineByExpired(String lastAccessTime);
}