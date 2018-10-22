package zjnu.cmf.project.system.bean;

/**
 * 角色和菜单关联 sys_role_menu
 * 
 * @author ruoyi
 */
public class RoleMenu
{
    /** 角色ID */
    private Integer roleId;
    /** 菜单ID */
    private Integer menuId;

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    public Integer getMenuId()
    {
        return menuId;
    }

    public void setMenuId(Integer menuId)
    {
        this.menuId = menuId;
    }

    @Override
    public String toString()
    {
        return "RoleMenu [roleId=" + roleId + ", menuId=" + menuId + "]";
    }

}
