package zjnu.cmf.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.common.constant.UserConstants;
import zjnu.cmf.common.utils.StringUtils;
import zjnu.cmf.project.system.mapper.PostMapper;
import zjnu.cmf.project.system.bean.Post;
import zjnu.cmf.project.system.mapper.UserPostMapper;
import zjnu.cmf.project.system.service.IPostService;
import zjnu.cmf.common.utils.Convert;

/**
 * 岗位 服务层实现
 * 
 * @author cmf
 * @date 2018-10-13
 */
@Service
public class PostServiceImpl implements IPostService 
{
	@Autowired
	private PostMapper postMapper;

	@Autowired
	private UserPostMapper userPostMapper;

	/**
     * 查询岗位信息
     * 
     * @param postId 岗位ID
     * @return 岗位信息
     */
    @Override
	public Post selectPostById(Integer postId)
	{
	    return postMapper.selectPostById(postId);
	}
	
	/**
     * 查询岗位列表
     * 
     * @param post 岗位信息
     * @return 岗位集合
     */
	@Override
	public List<Post> selectPostList(Post post)
	{
	    return postMapper.selectPostList(post);
	}

	/**
	 * 查询所有岗位
	 *
	 * @return 岗位列表
	 */
	@Override
	public List<Post> selectPostAll()
	{
		return postMapper.selectPostAll();
	}

	/**
	 * 根据用户ID查询岗位
	 *
	 * @param userId 用户ID
	 * @return 岗位列表
	 */
	@Override
	public List<Post> selectPostsByUserId(Integer userId)
	{
		List<Post> userPosts = postMapper.selectPostsByUserId(userId);
		List<Post> posts = postMapper.selectPostAll();
		for (Post post : posts)
		{
			for (Post userRole : userPosts)
			{
				if (post.getPostId().longValue() == userRole.getPostId().longValue())
				{
					post.setFlag(true);
					break;
				}
			}
		}
		return posts;
	}



    /**
     * 新增岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	@Override
	public int insertPost(Post post)
	{
	    return postMapper.insertPost(post);
	}
	
	/**
     * 修改岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	@Override
	public int updatePost(Post post)
	{
	    return postMapper.updatePost(post);
	}

	/**
     * 删除岗位对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePostByIds(String ids) throws Exception {
		Integer[] postIds = Convert.toLongArray(ids);
		for (Integer postId : postIds)
		{
			Post post = selectPostById(postId);
			if (countUserPostById(postId) > 0)
			{
				throw new Exception(String.format("%1$s已分配,不能删除", post.getPostName()));
			}
		}
		return postMapper.deletePostByIds(Convert.toStrArray(ids));
	}

	/**
	 * 通过岗位ID查询岗位使用数量
	 *
	 * @param postId 岗位ID
	 * @return 结果
	 */
	@Override
	public int countUserPostById(Integer postId)
	{
		return userPostMapper.countUserPostById(postId);
	}

	/**
	 * 校验岗位名称是否唯一
	 * @param post 岗位信息
	 * @return
	 */
	@Override
	public String checkPostNameUnique(Post post) {
		Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
		Post info = postMapper.checkPostNameUnique(post.getPostName());
		if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue())
		{
			return UserConstants.POST_NAME_NOT_UNIQUE;
		}
		return UserConstants.POST_NAME_UNIQUE;
	}

	/**
	 * 校验岗位编码是否唯一
	 *
	 * @param post 岗位信息
	 * @return 结果
	 */
	@Override
	public String checkPostCodeUnique(Post post)
	{
		Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
		Post info = postMapper.checkPostCodeUnique(post.getPostCode());
		if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue())
		{
			return UserConstants.POST_CODE_NOT_UNIQUE;
		}
		return UserConstants.POST_CODE_UNIQUE;
	}

}
