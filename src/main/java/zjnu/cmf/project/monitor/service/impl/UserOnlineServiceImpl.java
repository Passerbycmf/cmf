package zjnu.cmf.project.monitor.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.common.utils.DateUtils;
import zjnu.cmf.common.utils.StringUtils;
import zjnu.cmf.framework.shiro.session.OnlineSessionDAO;
import zjnu.cmf.project.monitor.mapper.UserOnlineMapper;
import zjnu.cmf.project.monitor.bean.UserOnline;
import zjnu.cmf.project.monitor.service.IUserOnlineService;
import zjnu.cmf.common.utils.Convert;

/**
 * 在线用户记录 服务层实现
 * 
 * @author cmf
 * @date 2018-10-11
 */
@Service
public class UserOnlineServiceImpl implements IUserOnlineService 
{
	@Autowired
	private UserOnlineMapper userOnlineMapper;



	@Autowired
	private OnlineSessionDAO onlineSessionDAO;
	/**
     * 查询在线用户记录信息
     * 
     * @param sessionId 在线用户记录ID
     * @return 在线用户记录信息
     */
    @Override
	public UserOnline selectUserOnlineById(String sessionId)
	{
		return userOnlineMapper.selectUserOnlineById(sessionId);
	}
	
	/**
     * 查询在线用户记录列表
     * 
     * @param userOnline 在线用户记录信息
     * @return 在线用户记录集合
     */
	@Override
	public List<UserOnline> selectUserOnlineList(UserOnline userOnline)
	{
	    return userOnlineMapper.selectUserOnlineList(userOnline);
	}
	
    /**
     * 新增在线用户记录
     * 
     * @param userOnline 在线用户记录信息
     * @return 结果
     */
	@Override
	public int insertUserOnline(UserOnline userOnline)
	{
	    return userOnlineMapper.insertUserOnline(userOnline);
	}
	
	/**
     * 修改在线用户记录
     * 
     * @param userOnline 在线用户记录信息
     * @return 结果
     */
	@Override
	public int updateUserOnline(UserOnline userOnline)
	{
	    return userOnlineMapper.updateUserOnline(userOnline);
	}

	/**
     * 删除在线用户记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserOnlineByIds(String ids)
	{
		return userOnlineMapper.deleteUserOnlineByIds(Convert.toStrArray(ids));
	}

	/**
	 * 通过会话序号查询信息
	 *
	 * @param sessionId 会话ID
	 * @return 在线用户信息
	 */
	@Override
	public UserOnline selectOnlineById(String sessionId)
	{
		return userOnlineMapper.selectOnlineById(sessionId);
	}

	/**
	 * 保存会话信息
	 *
	 * @param online 会话信息
	 */
	@Override
	public void saveOnline(UserOnline online)
	{
		userOnlineMapper.saveOnline(online);
	}

	/**
	 * 通过会话序号删除信息
	 *
	 * @param sessionId 会话ID
	 * @return 在线用户信息
	 */
	@Override
	public void deleteOnlineById(String sessionId)
	{
		UserOnline userOnline = selectOnlineById(sessionId);
		if (StringUtils.isNotNull(userOnline))
		{
			userOnlineMapper.deleteOnlineById(sessionId);
		}
	}

	/**
	 * 查询会话集合
	 *
	 * @param expiredDate 会话信息
	 */
	@Override
	public List<UserOnline> selectOnlineByExpired(Date expiredDate)
	{
		String lastAccessTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, expiredDate);
		return userOnlineMapper.selectOnlineByExpired(lastAccessTime);
	}

	/**
	 * 通过会话序号删除信息
	 *
	 * @param sessions 会话ID集合
	 * @return 在线用户信息
	 */
	@Override
	public void batchDeleteOnline(List<String> sessions)
	{
		for (String sessionId : sessions)
		{
			UserOnline userOnline = selectOnlineById(sessionId);
			if (StringUtils.isNotNull(userOnline))
			{
				userOnlineMapper.deleteOnlineById(sessionId);
			}
		}
	}

	/**
	 * 强退用户
	 *
	 * @param sessionId 会话ID
	 */
	@Override
	public void forceLogout(String sessionId)
	{
		Session session = onlineSessionDAO.readSession(sessionId);
		if (session == null)
		{
			return;
		}
		session.setTimeout(1000);
		userOnlineMapper.deleteOnlineById(sessionId);
	}


}
