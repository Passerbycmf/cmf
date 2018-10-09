package zjnu.cmf.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import zjnu.cmf.framework.web.BaseEntity;

import java.util.Date;

/**
 * 字典数据表 sys_dict_data
 * 
 * @author cmf
 * @date 2018-08-14
 */
public class DictData extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 字典编码 */
	private Integer dictCode;
	/** 字典排序 */
	private Integer dictSort;
	/** 字典标签 */
	private String dictLabel;
	/** 字典键值 */
	private String dictValue;
	/** 字典类型 */
	private String dictType;
	/** 样式属性 */
	private String cssClass;
	/** 回显样式 */
	private String listClass;
	/** 是否默认（Y是 N否） */
	private String isDefault;
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

	public void setDictCode(Integer dictCode) 
	{
		this.dictCode = dictCode;
	}

	public Integer getDictCode() 
	{
		return dictCode;
	}
	public void setDictSort(Integer dictSort) 
	{
		this.dictSort = dictSort;
	}

	public Integer getDictSort() 
	{
		return dictSort;
	}
	public void setDictLabel(String dictLabel) 
	{
		this.dictLabel = dictLabel;
	}

	public String getDictLabel() 
	{
		return dictLabel;
	}
	public void setDictValue(String dictValue) 
	{
		this.dictValue = dictValue;
	}

	public String getDictValue() 
	{
		return dictValue;
	}
	public void setDictType(String dictType) 
	{
		this.dictType = dictType;
	}

	public String getDictType() 
	{
		return dictType;
	}
	public void setCssClass(String cssClass) 
	{
		this.cssClass = cssClass;
	}

	public String getCssClass() 
	{
		return cssClass;
	}
	public void setListClass(String listClass) 
	{
		this.listClass = listClass;
	}

	public String getListClass() 
	{
		return listClass;
	}
	public void setIsDefault(String isDefault) 
	{
		this.isDefault = isDefault;
	}

	public String getIsDefault() 
	{
		return isDefault;
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
            .append("dictCode", getDictCode())
            .append("dictSort", getDictSort())
            .append("dictLabel", getDictLabel())
            .append("dictValue", getDictValue())
            .append("dictType", getDictType())
            .append("cssClass", getCssClass())
            .append("listClass", getListClass())
            .append("isDefault", getIsDefault())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
