package zjnu.cmf.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.common.utils.ShiroUtils;
import zjnu.cmf.project.system.mapper.NoticeMapper;
import zjnu.cmf.project.system.bean.Notice;
import zjnu.cmf.project.system.service.INoticeService;
import zjnu.cmf.common.utils.Convert;

/**
 * 通知公告 服务层实现
 * 
 * @author cmf
 * @date 2018-10-20
 */
@Service
public class NoticeServiceImpl implements INoticeService 
{
	@Autowired
	private NoticeMapper noticeMapper;

	/**
     * 查询通知公告信息
     * 
     * @param noticeId 通知公告ID
     * @return 通知公告信息
     */
    @Override
	public Notice selectNoticeById(Integer noticeId)
	{
	    return noticeMapper.selectNoticeById(noticeId);
	}
	
	/**
     * 查询通知公告列表
     * 
     * @param notice 通知公告信息
     * @return 通知公告集合
     */
	@Override
	public List<Notice> selectNoticeList(Notice notice)
	{
	    return noticeMapper.selectNoticeList(notice);
	}
	
    /**
     * 新增通知公告
     * 
     * @param notice 通知公告信息
     * @return 结果
     */
	@Override
	public int insertNotice(Notice notice)
	{
		notice.setCreateBy(ShiroUtils.getLoginName());
		return noticeMapper.insertNotice(notice);
	}
	
	/**
     * 修改通知公告
     * 
     * @param notice 通知公告信息
     * @return 结果
     */
	@Override
	public int updateNotice(Notice notice)
	{
		notice.setUpdateBy(ShiroUtils.getLoginName());
		return noticeMapper.updateNotice(notice);

	}

	/**
     * 删除通知公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteNoticeByIds(String ids)
	{
		return noticeMapper.deleteNoticeByIds(Convert.toStrArray(ids));
	}
	
}
