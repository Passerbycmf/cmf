package zjnu.cmf.project.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zjnu.cmf.common.utils.StringUtils;
import zjnu.cmf.framework.aspectj.lang.annotation.Log;
import zjnu.cmf.framework.aspectj.lang.constant.BusinessType;
import zjnu.cmf.project.system.bean.Post;
import zjnu.cmf.project.system.service.IPostService;
import zjnu.cmf.framework.web.TableDataInfo;
import zjnu.cmf.framework.web.AjaxResult;
import zjnu.cmf.framework.web.BaseController;

/**
 * 岗位 信息操作处理
 * 
 * @author cmf
 * @date 2018-10-13
 */
@Controller
@RequestMapping("/system/post")
public class PostController extends BaseController
{
    private String prefix = "system/post";
	
	@Autowired
	private IPostService postService;
	
	@RequiresPermissions("system:post:view")
	@GetMapping()
	public String post()
	{
	    return prefix + "/post";
	}
	
	/**
	 * 查询岗位列表
	 */
	@RequiresPermissions("system:post:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Post post)
	{
		startPage();
        List<Post> list = postService.selectPostList(post);
		return getDataTable(list);
	}
	
	/**
	 * 新增岗位
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存岗位
	 */
	@RequiresPermissions("system:post:add")
	@Log(title = "岗位", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Post post)
	{		
		return toAjax(postService.insertPost(post));
	}

	/**
	 * 修改岗位
	 */
	@GetMapping("/edit/{postId}")
	public String edit(@PathVariable("postId") Integer postId, ModelMap mmap)
	{
		Post post = postService.selectPostById(postId);
		mmap.put("post", post);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存岗位
	 */
	@RequiresPermissions("system:post:edit")
	@Log(title = "岗位", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Post post)
	{		
		return toAjax(postService.updatePost(post));
	}

	/**
	 * 校验岗位名称是否唯一
	 */
	@PostMapping("/checkPostNameUnique")
	@ResponseBody
	public String checkPostNameUnique(Post post)
	{
		String uniqueFlag = "0";
		if (StringUtils.isNotNull(post))
		{
			uniqueFlag = postService.checkPostNameUnique(post);
		}
		return uniqueFlag;
	}

	/**
	 * 校验岗位编码是否唯一
	 */
	@PostMapping("/checkPostCodeUnique")
	@ResponseBody
	public String checkPostCodeUnique(Post post)
	{
		String uniqueFlag = "0";
		if (StringUtils.isNotNull(post))
		{
			uniqueFlag = postService.checkPostCodeUnique(post);
		}
		return uniqueFlag;
	}

	/**
	 * 删除岗位
	 */
	@RequiresPermissions("system:post:remove")
	@Log(title = "岗位管理", action = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		try
		{
			return toAjax(postService.deletePostByIds(ids));
		}
		catch (Exception e)
		{
			return error(e.getMessage());
		}
	}
}
