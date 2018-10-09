package zjnu.cmf.system.controller;


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
import zjnu.cmf.system.bean.DictData;
import zjnu.cmf.system.service.IDictDataService;

import java.util.List;


/**
 * 字典数据 信息操作处理
 * 
 * @author cmf
 * @date 2018-08-14
 */
@Controller
@RequestMapping("/system/dictData")
public class DictDataController extends BaseController
{
    private String prefix = "system/dict/data";
	
	@Autowired
	private IDictDataService dictDataService;
	
	@RequiresPermissions("system:dictData:view")
	@GetMapping()
	public String dictData()
	{
	    return prefix + "/dictData";
	}
	
	/**
	 * 查询字典数据列表
	 */
	@RequiresPermissions("system:dictData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DictData dictData)
	{
		startPage();
        List<DictData> list = dictDataService.selectDictDataList(dictData);
		return getDataTable(list);
	}

	/**
	 * 新增字典类型
	 */
	@GetMapping("/add/{dictType}")
	public String add(@PathVariable("dictType") String dictType, ModelMap mmap)
	{
		mmap.put("dictType", dictType);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存字典数据
	 */
	@RequiresPermissions("system:dictData:add")
	@Log(title = "字典数据", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DictData dictData)
	{		
		return toAjax(dictDataService.insertDictData(dictData));
	}

	/**
	 * 修改字典数据
	 */
	@GetMapping("/edit/{dictCode}")
	public String edit(@PathVariable("dictCode") Integer dictCode, ModelMap mmap)
	{
		DictData dictData = dictDataService.selectDictDataById(dictCode);
		mmap.put("dictData", dictData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存字典数据
	 */
	@RequiresPermissions("system:dictData:edit")
	@Log(title = "字典数据", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(DictData dictData)
	{		
		return toAjax(dictDataService.updateDictData(dictData));
	}
	
	/**
	 * 删除字典数据
	 */
	@RequiresPermissions("system:dictData:remove")
	@Log(title = "字典数据", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(dictDataService.deleteDictDataByIds(ids));
	}
	
}
