package zjnu.cmf.project.system.mapper;

import zjnu.cmf.project.system.bean.Post;
import java.util.List;	

/**
 * 岗位 数据层
 * 
 * @author cmf
 * @date 2018-10-13
 */
public interface PostMapper 
{
	/**
     * 查询岗位信息
     * 
     * @param postId 岗位ID
     * @return 岗位信息
     */
	public Post selectPostById(Integer postId);
	
	/**
     * 查询岗位列表
     * 
     * @param post 岗位信息
     * @return 岗位集合
     */
	public List<Post> selectPostList(Post post);
	
	/**
     * 新增岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	public int insertPost(Post post);
	
	/**
     * 修改岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	public int updatePost(Post post);
	
	/**
     * 删除岗位
     * 
     * @param postId 岗位ID
     * @return 结果
     */
	public int deletePostById(Integer postId);
	
	/**
     * 批量删除岗位
     * 
     * @param postIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePostByIds(String[] postIds);

	/**
	 * 校验岗位名称是否唯一
	 *
	 * @param postName 岗位名称
	 * @return 结果
	 */
	 Post checkPostNameUnique(String postName);

	/**
	 * 校验岗位编码
	 *
	 * @param postCode 岗位编码
	 * @return 结果
	 */
	 Post checkPostCodeUnique(String postCode);

	/**
	 * 查询所有岗位
	 *
	 * @return 岗位列表
	 */
	 List<Post> selectPostAll();

	/**
	 * 根据用户ID查询岗位
	 *
	 * @param userId 用户ID
	 * @return 岗位列表
	 */
	 List<Post> selectPostsByUserId(Integer userId);
}