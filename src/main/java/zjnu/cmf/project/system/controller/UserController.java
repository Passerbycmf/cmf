package zjnu.cmf.project.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zjnu.cmf.common.utils.StringUtils;
import zjnu.cmf.framework.aspectj.lang.annotation.Log;
import zjnu.cmf.framework.aspectj.lang.constant.BusinessType;
import zjnu.cmf.framework.web.AjaxResult;
import zjnu.cmf.framework.web.BaseController;
import zjnu.cmf.framework.web.TableDataInfo;
import zjnu.cmf.project.system.bean.User;
import zjnu.cmf.project.system.mapper.UserRoleMapper;
import zjnu.cmf.project.system.service.IPostService;
import zjnu.cmf.project.system.service.IRoleService;
import zjnu.cmf.project.system.service.IUserService;

/**
 * 用户 信息操作处理
 * 
 * @author cmf
 * @date 2018-08-12
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController
{
    private String prefix = "system/user";
	
	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IPostService postService;


	
	@RequiresPermissions("system:user:view")
	@GetMapping()
	public String user()
	{
	    return prefix + "/user";
	}


	/**
	 * 查询用户列表
	 */
	@RequiresPermissions("system:user:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(User user)
	{
		startPage();
        List<User> list = userService.selectUserList(user);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户
	 */
	@GetMapping("/add")
	public String add(ModelMap map)
	{
	    map.put("roles",roleService.selectRoleAll());
		map.put("posts", postService.selectPostAll());
		return prefix + "/add";
	}
	
	/**
	 * 新增保存用户
	 */
	@RequiresPermissions("system:user:add")
	@Log(title = "用户", action = BusinessType.INSERT)
	@PostMapping("/add")
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public AjaxResult addSave(User user)
	{
		if (StringUtils.isNotNull(user.getUserId()) && User.isAdmin(user.getUserId())){
			return error("不允许修改超级管理员用户");
		}
		return toAjax(userService.insertUser(user));
	}

	/**
	 * 修改用户
	 */
	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") Integer userId, ModelMap mmap)
	{
		User user = userService.selectUserById(userId);
		mmap.put("user", user);
		mmap.put("roles",roleService.selectRolesByUserId(userId));
		mmap.put("posts", postService.selectPostsByUserId(userId));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户
	 */
	@RequiresPermissions("system:user:edit")
	@Log(title = "用户", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public AjaxResult editSave(User user)
	{		
        if (StringUtils.isNotNull(user.getUserId()) && User.isAdmin(user.getUserId())){
        	return error("不允许修改超级管理员用户");
		}
		return toAjax(userService.updateUser(user));
	}

	/**
	 * 密码重置
	 * @param userId
	 * @param map
	 * @return
	 */
	@RequiresPermissions("system:user:resetPwd")
	@Log(title = "重置密码",action = BusinessType.UPDATE)
	@GetMapping("/resetPwd/{userId}")
	public String resetPwd(@PathVariable("userId") Integer userId,ModelMap map){
		map.put("user",userService.selectUserById(userId));
		return prefix + "/resetPwd";
	}

	/**
	 * 修改用户密码信息
	 * @param user 用户信息
	 * @return 结果
	 */
	@RequiresPermissions("system:user:resetPwd")
	@Log(title = "重置密码", action = BusinessType.UPDATE)
	@PostMapping("/resetPwd")
	@ResponseBody
	public AjaxResult resetPwd(User user)
	{
		return toAjax(userService.resetUserPwd(user));
	}

	/**
	 * 删除用户
	 */
	@RequiresPermissions("system:user:remove")
	@Log(title = "用户", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		try{
			return toAjax(userService.deleteUserByIds(ids));
		}
		catch (Exception e){
			return error(e.getMessage());
		}
	}

	/**
	 * 校验用户名是否唯一
	 * @param user
	 * @return
	 */
	@PostMapping("/checkLoginNameUnique")
	@ResponseBody
	public String checkLoginNameUnique(User user){
		String uniqueFlag = "0";
		if (StringUtils.isNotNull(user)){
			uniqueFlag = userService.checkLoginNameUnique(user.getLoginName());
		}
		return uniqueFlag;
	}

	/**
	 * 校验手机号码是否唯一
	 * @param user
	 * @return
	 */
	@PostMapping("/checkPhoneUnique")
	@ResponseBody
	public String checkPhoneUnique(User user){
		String uniqueFlag = "0";
		if(StringUtils.isNotNull(user)){
			uniqueFlag = userService.checkPhoneUnique(user);
		}
		return uniqueFlag;
	}

	/**
	 * 校验email邮箱是否唯一
	 * @param user
	 * @return
	 */
	@PostMapping("/checkEmailUnique")
	@ResponseBody
	public String checkEmailUnique(User user){
		String uniqueFlag = "0";
		if(StringUtils.isNotNull(user)){
			uniqueFlag = userService.checkEmailUnique(user);
		}
		return uniqueFlag;
	}
	
}
