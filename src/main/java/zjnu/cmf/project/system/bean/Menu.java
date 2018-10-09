package zjnu.cmf.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.cmf.framework.web.BaseEntity;

import java.util.Date;

/**
 * 菜单权限表 sys_menu
 * 
 * @author cmf
 * @date 2018-08-12
 */
public class Menu extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 菜单ID */
	private Integer menuId;
	/** 菜单名称 */
	private String menuName;
	/** 父菜单ID */
	private Integer parentId;
	/** 显示顺序 */
	private Integer orderNum;
	/** 请求地址 */
	private String url;
	/** 菜单类型（M目录 C菜单 F按钮） */
	private String menuType;
	/** 菜单状态（0显示 1隐藏） */
	private String visible;
	/** 权限标识 */
	private String perms;
	/** 菜单图标 */
	private String icon;
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

	public void setMenuId(Integer menuId) 
	{
		this.menuId = menuId;
	}

	public Integer getMenuId() 
	{
		return menuId;
	}
	public void setMenuName(String menuName) 
	{
		this.menuName = menuName;
	}

	public String getMenuName() 
	{
		return menuName;
	}
	public void setParentId(Integer parentId) 
	{
		this.parentId = parentId;
	}

	public Integer getParentId() 
	{
		return parentId;
	}
	public void setOrderNum(Integer orderNum) 
	{
		this.orderNum = orderNum;
	}

	public Integer getOrderNum() 
	{
		return orderNum;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	public void setMenuType(String menuType) 
	{
		this.menuType = menuType;
	}

	public String getMenuType() 
	{
		return menuType;
	}
	public void setVisible(String visible) 
	{
		this.visible = visible;
	}

	public String getVisible() 
	{
		return visible;
	}
	public void setPerms(String perms) 
	{
		this.perms = perms;
	}

	public String getPerms() 
	{
		return perms;
	}
	public void setIcon(String icon) 
	{
		this.icon = icon;
	}

	public String getIcon() 
	{
		return icon;
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
            .append("menuId", getMenuId())
            .append("menuName", getMenuName())
            .append("parentId", getParentId())
            .append("orderNum", getOrderNum())
            .append("url", getUrl())
            .append("menuType", getMenuType())
            .append("visible", getVisible())
            .append("perms", getPerms())
            .append("icon", getIcon())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
