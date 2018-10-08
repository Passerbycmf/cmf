package zjnu.cmf.project.controller;

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
import zjnu.cmf.framework.aspectj.lang.annotation.Log;
import zjnu.cmf.framework.aspectj.lang.constant.BusinessType;
import zjnu.cmf.project.bean.Role;
import zjnu.cmf.project.service.IRoleService;
import zjnu.cmf.framework.web.TableDataInfo;
import zjnu.cmf.framework.web.AjaxResult;
import zjnu.cmf.framework.web.BaseController;

/**
 * 角色 信息操作处理
 * 
 * @author cmf
 * @date 2018-10-08
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController
{
    private String prefix = "role";
	
	@Autowired
	private IRoleService roleService;
	
	@RequiresPermissions("role:view")
	@GetMapping()
	public String role()
	{
	    return prefix + "/role";
	}
	
	/**
	 * 查询角色列表
	 */
	@RequiresPermissions("role:list")
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
	@RequiresPermissions("role:add")
	@Log(title = "角色", action = BusinessType.INSERT)
	@PostMapping("/add")
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
	@RequiresPermissions("role:edit")
	@Log(title = "角色", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Role role)
	{		
		return toAjax(roleService.updateRole(role));
	}
	
	/**
	 * 删除角色
	 */
	@RequiresPermissions("role:remove")
	@Log(title = "角色", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(roleService.deleteRoleByIds(ids));
	}
	
}
