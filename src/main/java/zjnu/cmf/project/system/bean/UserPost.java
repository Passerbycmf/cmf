package zjnu.cmf.project.system.bean;

/**
 * 用户和岗位关联 sys_user_post
 * 
 * @author cmf
 */
public class UserPost
{
    /** 用户ID */
    private Integer userId;
    /** 岗位ID */
    private Integer postId;

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getPostId()
    {
        return postId;
    }

    public void setPostId(Integer postId)
    {
        this.postId = postId;
    }

    @Override
    public String toString()
    {
        return "UserPost [userId=" + userId + ", postId=" + postId + "]";
    }

}
