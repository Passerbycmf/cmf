package zjnu.cmf.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import zjnu.cmf.common.constant.UserConstants;
import zjnu.cmf.common.utils.StringUtils;
import zjnu.cmf.framework.aspectj.lang.annotation.Log;
import zjnu.cmf.framework.aspectj.lang.constant.BusinessType;
import zjnu.cmf.framework.web.AjaxResult;
import zjnu.cmf.framework.web.BaseController;
import zjnu.cmf.framework.web.TableDataInfo;
import zjnu.cmf.project.bean.Dept;
import zjnu.cmf.project.mapper.DeptMapper;
import zjnu.cmf.project.service.IDeptService;


/**
 * 部门 信息操作处理
 * 
 * @author cmf
 * @date 2018-08-12
 */
@Controller
@RequestMapping("/system/dept")
public class DeptController extends BaseController
{
    private String prefix = "system/dept";
	
	@Autowired
	private IDeptService deptService;

	@Autowired
	private DeptMapper deptMapper;
	
	@RequiresPermissions("system:dept:view")
	@GetMapping()
	public String dept()
	{
	    return prefix + "/dept";
	}
	
	/**
	 * 查询部门列表
	 */
	@RequiresPermissions("system:dept:list")
	@GetMapping("/list")
	@ResponseBody
	public List<Dept> list(Dept dept)
	{
		/*startPage();
        List<Dept> list = deptService.selectDeptList(dept);
		return getDataTable(list);*/
		List<Dept> deptList = deptService.selectDeptList(dept);
		return deptList;
	}
	
	/**
	 * 新增部门
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") Integer parentId,ModelMap map)
	{
	    //回显父部门
		map.put("dept",deptService.selectDeptById(parentId));
		return prefix + "/add";
	}
	
	/**
	 * 新增保存部门
	 */
	@RequiresPermissions("system:dept:add")
	@Log(title = "部门", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Dept dept)
	{		
		return toAjax(deptService.insertDept(dept));
	}

	/**
	 * 修改部门
	 */
	@GetMapping("/edit/{deptId}")
	public String edit(@PathVariable("deptId") Integer deptId, ModelMap mmap)
	{
		//数据回显
		Dept dept = deptService.selectDeptById(deptId);
		mmap.put("dept", dept);
	    return prefix + "/edit";
	}
	
	/**
	 * 保存修改部门
	 */
	@RequiresPermissions("system:dept:edit")
	@Log(title = "部门", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Dept dept)
	{		
		return toAjax(deptService.updateDept(dept));
	}
	
	/**
	 * 删除部门
	 */
	@RequiresPermissions("system:dept:remove")
	@Log(title = "部门", action = BusinessType.DELETE)
	@PostMapping( "/remove/{deptId}")
	@ResponseBody
	public AjaxResult remove(@PathVariable("deptId") Integer deptId )
	{
		if (deptService.selectDeptCount(deptId) > 0){
			return error(1,"存在下级部门，不允许删除！");
		}
		if(deptService.checkDeptExistUser(deptId)){
			return error(1,"部门存在用户，不允许删除！");
		}
		return toAjax(deptService.deleteDeptById(deptId));
	}

	/**
	 * 选择部门树（回显部门）
	 * @param deptId
	 * @param map
	 * @return
	 */
	@GetMapping("/selectDeptTree/{deptId}")
	public String selectDeptTree(@PathVariable("deptId") Integer deptId, ModelMap map){
		map.put("treeName",deptService.selectDeptById(deptId).getDeptName());
		return prefix + "/tree";
	}

	/**
	 * 加载部门列表树
	 * @return
	 */
	@GetMapping("/treeData")
	@ResponseBody
	public List<Map<String,Object>> treeData(){
		List<Map<String,Object>> tree = new ArrayList<>();
		List<Dept> deptList = deptMapper.selectDeptAll();
		//遍历
		for(Dept dept : deptList){
			//部门正常状态
			if(UserConstants.DEPT_NORMAL.equals(dept.getStatus())){
				Map<String,Object> deptMap = new HashMap<>();
				deptMap.put("id", dept.getDeptId());
				deptMap.put("pId", dept.getParentId());
				deptMap.put("name", dept.getDeptName());
				deptMap.put("title", dept.getDeptName());
				tree.add(deptMap);
			}
		}
		return tree;
	}

	/**
	 * 校验部门名称
	 * @param dept
	 * @return
	 */
	@PostMapping("/checkDeptNameUnique")
	@ResponseBody
	public String checkDeptNameUnique(Dept dept){
		String uniqueFlag = "0";
		if(StringUtils.isNotNull(dept)){
			uniqueFlag = deptService.checkDeptNameUnique(dept);
		}
		return uniqueFlag;
	}

}
