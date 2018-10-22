package zjnu.cmf.project.system.bean;

/**
 * 用户和角色关联 sys_user_role
 * 
 * @author ruoyi
 */
public class UserRole
{
    /** 用户ID */
    private Integer userId;
    /** 角色ID */
    private Integer roleId;

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String toString()
    {
        return "UserRole [userId=" + userId + ", roleId=" + roleId + "]";
    }

}
