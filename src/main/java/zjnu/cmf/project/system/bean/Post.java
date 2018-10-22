package zjnu.cmf.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.cmf.framework.web.BaseEntity;
import java.util.Date;

/**
 * 岗位表 sys_post
 * 
 * @author cmf
 * @date 2018-10-13
 */
public class Post extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 岗位ID */
	private Integer postId;
	/** 岗位编码 */
	private String postCode;
	/** 岗位名称 */
	private String postName;
	/** 显示顺序 */
	private Integer postSort;
	/** 状态（0正常 1停用） */
	private String status;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;
	/** 用户是否存在此岗位标识 默认不存在 */
	private boolean flag = false;

	public void setPostId(Integer postId) 
	{
		this.postId = postId;
	}

	public Integer getPostId() 
	{
		return postId;
	}
	public void setPostCode(String postCode) 
	{
		this.postCode = postCode;
	}

	public String getPostCode() 
	{
		return postCode;
	}
	public void setPostName(String postName) 
	{
		this.postName = postName;
	}

	public String getPostName() 
	{
		return postName;
	}
	public void setPostSort(Integer postSort) 
	{
		this.postSort = postSort;
	}

	public Integer getPostSort() 
	{
		return postSort;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

	public boolean isFlag()
	{
		return flag;
	}

	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("postCode", getPostCode())
            .append("postName", getPostName())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
