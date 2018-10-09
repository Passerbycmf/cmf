package zjnu.cmf.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.cmf.framework.web.BaseEntity;

import java.util.Date;

/**
 * 字典类型表 sys_dict_type
 * 
 * @author cmf
 * @date 2018-08-14
 */
public class DictType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 字典主键 */
	private Integer dictId;
	/** 字典名称 */
	private String dictName;
	/** 字典类型 */
	private String dictType;
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

	public void setDictId(Integer dictId) 
	{
		this.dictId = dictId;
	}

	public Integer getDictId() 
	{
		return dictId;
	}
	public void setDictName(String dictName) 
	{
		this.dictName = dictName;
	}

	public String getDictName() 
	{
		return dictName;
	}
	public void setDictType(String dictType) 
	{
		this.dictType = dictType;
	}

	public String getDictType() 
	{
		return dictType;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dictId", getDictId())
            .append("dictName", getDictName())
            .append("dictType", getDictType())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
