package zjnu.cmf.project.controller;

import java.util.List;
import java.util.Map;

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
import zjnu.cmf.framework.web.AjaxResult;
import zjnu.cmf.framework.web.BaseController;
import zjnu.cmf.framework.web.TableDataInfo;
import zjnu.cmf.project.bean.Menu;
import zjnu.cmf.project.service.IMenuService;


/**
 * 菜单权限 信息操作处理
 * 
 * @author cmf
 * @date 2018-08-12
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController extends BaseController
{
    private String prefix = "system/menu";
	
	@Autowired
	private IMenuService menuService;
	
	@RequiresPermissions("system:menu:view")
	@GetMapping()
	public String menu()
	{
	    return prefix + "/menu";
	}
	
	/**
	 * 查询菜单权限列表
	 */
	@RequiresPermissions("system:menu:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Menu menu)
	{
		startPage();
        List<Menu> list = menuService.selectMenuList(menu);
		return getDataTable(list);
	}
	
	/**
	 * 新增菜单权限
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存菜单权限
	 */
	@RequiresPermissions("system:menu:add")
	@Log(title = "菜单权限", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Menu menu)
	{		
		return toAjax(menuService.insertMenu(menu));
	}

	/**
	 * 修改菜单权限
	 */
	@GetMapping("/edit/{menuId}")
	public String edit(@PathVariable("menuId") Long menuId, ModelMap mmap)
	{
		Menu menu = menuService.selectMenuById(menuId);
		mmap.put("menu", menu);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存菜单权限
	 */
	@RequiresPermissions("system:menu:edit")
	@Log(title = "菜单权限", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Menu menu)
	{		
		return toAjax(menuService.updateMenu(menu));
	}
	
	/**
	 * 删除菜单权限
	 */
	@RequiresPermissions("system:menu:remove")
	@Log(title = "菜单权限", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(menuService.deleteMenuByIds(ids));
	}

	/**
	 * 选择菜单图标
	 */
	@GetMapping("/icon")
	public String icon(){
		return prefix + "/icon";
	}


	/**
	 * 选择菜单树
	 */
	@GetMapping("/selectMenuTree/{menuId}")
	public String selectMenuTree(@PathVariable("menuId") Long menuId, ModelMap mmap)
	{
		mmap.put("treeName", menuService.selectMenuById(menuId).getMenuName());
		return prefix + "/tree";
	}
}

