package zjnu.cmf.system.controller;

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
import zjnu.cmf.common.utils.ExcelUtil;
import zjnu.cmf.common.utils.StringUtils;
import zjnu.cmf.framework.aspectj.lang.annotation.Log;
import zjnu.cmf.framework.aspectj.lang.constant.BusinessType;
import zjnu.cmf.framework.web.AjaxResult;
import zjnu.cmf.framework.web.BaseController;
import zjnu.cmf.framework.web.TableDataInfo;
import zjnu.cmf.system.bean.DictType;
import zjnu.cmf.system.service.IDictDataService;
import zjnu.cmf.system.service.IDictTypeService;


/**
 * 字典类型 信息操作处理
 * 
 * @author cmf
 * @date 2018-08-14
 */
@Controller
@RequestMapping("/system/dictType")
public class DictTypeController extends BaseController
{
    private String prefix = "system/dict/type";


	
	@Autowired
	private IDictTypeService dictTypeService;

	@Autowired
	private IDictDataService dictDataService;
	
	@RequiresPermissions("system:dictType:view")
	@GetMapping()
	public String dictType()
	{
	    return prefix + "/dictType";
	}
	
	/**
	 * 查询字典类型列表
	 */
	@RequiresPermissions("system:dictType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DictType dictType)
	{
		startPage();
        List<DictType> list = dictTypeService.selectDictTypeList(dictType);
		return getDataTable(list);
	}
	
	/**
	 * 新增字典类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存字典类型
	 */
	@RequiresPermissions("system:dictType:add")
	@Log(title = "字典类型", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DictType dictType)
	{		
		return toAjax(dictTypeService.insertDictType(dictType));
	}

	/**
	 * 修改字典类型
	 */
	@GetMapping("/edit/{dictId}")
	public String edit(@PathVariable("dictId") Integer dictId, ModelMap mmap)
	{
		DictType dictType = dictTypeService.selectDictTypeById(dictId);
		mmap.put("dictType", dictType);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存字典类型
	 */
	@RequiresPermissions("system:dictType:edit")
	@Log(title = "字典类型", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(DictType dictType)
	{		
		return toAjax(dictTypeService.updateDictType(dictType));
	}

	/**
	 * Excle导出
	 * @param dictType
	 * @return
	 */
	@Log(title = "字典类型",action = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(DictType dictType) throws Exception
	{
		try {
			List<DictType> dictList = dictTypeService.selectDictTypeList(dictType);
			ExcelUtil<DictType> util = new ExcelUtil<>(DictType.class);
		    return  util.exportExcel(dictList,"dictType");
		}catch (Exception e){
			return error("导出Excel失败请联系网站管理员！");
		}
	}

	/**
	 * 校验字典类型是否唯一
	 * @return
	 */
	@PostMapping("/checkDictTypeUnique")
	@ResponseBody
	public String checkDictTypeUnique(DictType dictType){
		String uniqueFlag = "0";
		if(StringUtils.isNotNull(dictType)){
         uniqueFlag = dictTypeService.checkDictTypeUnique(dictType);
		}
		return uniqueFlag;
	}

	/**
	 * 校验字典名称是否唯一
	 * @param dict
	 * @return
	 */
	@PostMapping("/checkDictNameUnique")
	@ResponseBody
	public String checkDictNameUnique(DictType dict){
		String uniqueFlag = "0";
		if(StringUtils.isNotNull(dict)){
			uniqueFlag = dictTypeService.checkDictNameUnique(dict);
		}
		return uniqueFlag;
	}

	/**
	 * 删除字典类型
	 */
	@RequiresPermissions("system:dictType:remove")
	@Log(title = "字典类型", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		try
		{
			return toAjax(dictTypeService.deleteDictTypeByIds(ids));
		}
		catch (Exception e)
		{
			return error(e.getMessage());
		}
	}

	/**
	 * 查询字典数据详情
	 * @param
	 * @return
	 */
	@GetMapping("/dictDataDetail/{dictId}")
	public String dictDataDetail(@PathVariable("dictId") Integer dictId, ModelMap map)
	{
		map.put("dict", dictTypeService.selectDictTypeById(dictId));
		map.put("dictList", dictTypeService.selectDictTypeAll());
		return "system/dict/data/dataData";
	}



}
