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
import zjnu.cmf.project.system.bean.Role;
import zjnu.cmf.project.system.service.IRoleService;
import zjnu.cmf.framework.web.TableDataInfo;
import zjnu.cmf.framework.web.AjaxResult;
import zjnu.cmf.framework.web.BaseController;

/**
 * 角色 信息操作处理
 * 
 * @author cmf
 * @date 2018-10-09
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController
{
    private String prefix = "system/role";
	
	@Autowired
	private IRoleService roleService;
	
	@RequiresPermissions("system:role:view")
	@GetMapping()
	public String role()
	{
	    return prefix + "/role";
	}
	
	/**
	 * 查询角色列表
	 */
	@RequiresPermissions("system:role:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Role role)
	{
		startPage();
        List<Role> list = roleService.selectRoleList(role);
		return getDataTable(list);
	}
	
	/**
	 * 新增角色
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存角色
	 */
	@RequiresPermissions("system:role:add")
	@Log(title = "角色", action = BusinessType.INSERT)
	@PostMapping("/add")
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public AjaxResult addSave(Role role)
	{		
		return toAjax(roleService.insertRole(role));
	}

	/**
	 * 修改角色
	 */
	@GetMapping("/edit/{roleId}")
	public String edit(@PathVariable("roleId") Integer roleId, ModelMap mmap)
	{
		Role role = roleService.selectRoleById(roleId);
		mmap.put("role", role);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存角色
	 */
	@RequiresPermissions("system:role:edit")
	@Log(title = "角色", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public AjaxResult editSave(Role role)
	{		
		return toAjax(roleService.updateRole(role));
	}
	
	/**
	 * 删除角色
	 */
	@RequiresPermissions("system:role:remove")
	@Log(title = "角色", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		try{
			return toAjax(roleService.deleteRoleByIds(ids));
		}
		catch (Exception e){
			return error(e.getMessage());
		}

	}

	/**
	 * 校验角色名称是否唯一
	 * @param role
	 * @return
	 */
	@PostMapping("/checkRoleNameUnique")
	@ResponseBody
	public String checkRoleNameUnique(Role role){
		String uniqueFlag = "0";
		if(StringUtils.isNotNull(role)){
			uniqueFlag = roleService.checkRoleNameUnique(role);
		}
		return uniqueFlag;
	}

	/**
	 * 校验角色限权是否唯一
	 * @param role
	 * @return
	 */
	@PostMapping("/checkRoleKeyUnique")
	@ResponseBody
	public String checkRoleKeyUnique(Role role){
		String uniqueFlag = "0";
		if (StringUtils.isNotNull(role)){
			uniqueFlag = roleService.checkRoleKeyUnique(role);
		}
		return uniqueFlag;
	}

	/**
	 * 选择菜单树
	 */
	@GetMapping("/selectMenuTree")
	public String selectMenuTree()
	{
		return prefix + "/tree";
	}
}
