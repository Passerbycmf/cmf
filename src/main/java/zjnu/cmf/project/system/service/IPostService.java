package zjnu.cmf.project.system.service;

import zjnu.cmf.project.system.bean.Post;
import java.util.List;

/**
 * 岗位 服务层
 * 
 * @author cmf
 * @date 2018-10-13
 */
public interface IPostService 
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
     * 删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePostByIds(String ids) throws Exception;

	/**
	 * 通过岗位ID查询岗位使用数量
	 *
	 * @param postId 岗位ID
	 * @return 结果
	 */
	 int countUserPostById(Integer postId);

	/**
	 * 校验岗位名称是否唯一
	 *
	 * @param post 岗位信息
	 * @return 结果
	 */
	 String checkPostNameUnique(Post post);

	/**
	 * 校验岗位编码是否唯一
	 *
	 * @param post 岗位信息
	 * @return 结果
	 */
	 String checkPostCodeUnique(Post post);
}
