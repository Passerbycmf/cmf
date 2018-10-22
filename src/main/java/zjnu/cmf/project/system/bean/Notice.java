package zjnu.cmf.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.cmf.framework.web.BaseEntity;
import java.util.Date;

/**
 * 通知公告表 sys_notice
 * 
 * @author cmf
 * @date 2018-10-20
 */

	public class Notice extends BaseEntity
	{
		private static final long serialVersionUID = 1L;

		/** 公告ID */
		private Integer noticeId;
		/** 公告标题 */
		private String noticeTitle;
		/** 公告类型（1通知 2公告） */
		private String noticeType;
		/** 公告内容 */
		private String noticeContent;
		/** 公告状态（0正常 1关闭） */
		private String status;

		public Integer getNoticeId()
		{
			return noticeId;
		}

		public void setNoticeId(Integer noticeId)
		{
			this.noticeId = noticeId;
		}

		public void setNoticeTitle(String noticeTitle)
		{
			this.noticeTitle = noticeTitle;
		}

		public String getNoticeTitle()
		{
			return noticeTitle;
		}

		public void setNoticeType(String noticeType)
		{
			this.noticeType = noticeType;
		}

		public String getNoticeType()
		{
			return noticeType;
		}

		public void setNoticeContent(String noticeContent)
		{
			this.noticeContent = noticeContent;
		}

		public String getNoticeContent()
		{
			return noticeContent;
		}

		public void setStatus(String status)
		{
			this.status = status;
		}

		public String getStatus()
		{
			return status;
		}

	}
