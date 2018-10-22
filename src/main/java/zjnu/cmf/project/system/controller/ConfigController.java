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
import zjnu.cmf.project.system.bean.Config;
import zjnu.cmf.project.system.service.IConfigService;
import zjnu.cmf.framework.web.TableDataInfo;
import zjnu.cmf.framework.web.AjaxResult;
import zjnu.cmf.framework.web.BaseController;

/**
 * 参数配置 信息操作处理
 * 
 * @author cmf
 * @date 2018-10-20
 */
@Controller
@RequestMapping("/system/config")
public class ConfigController extends BaseController
{
    private String prefix = "system/config";
	
	@Autowired
	private IConfigService configService;
	
	@RequiresPermissions("system:config:view")
	@GetMapping()
	public String config()
	{
	    return prefix + "/config";
	}
	
	/**
	 * 查询参数配置列表
	 */
	@RequiresPermissions("system:config:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Config config)
	{
		startPage();
        List<Config> list = configService.selectConfigList(config);
		return getDataTable(list);
	}
	
	/**
	 * 新增参数配置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存参数配置
	 */
	@RequiresPermissions("system:config:add")
	@Log(title = "参数配置", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Config config)
	{		
		return toAjax(configService.insertConfig(config));
	}

	/**
	 * 修改参数配置
	 */
	@GetMapping("/edit/{configId}")
	public String edit(@PathVariable("configId") Integer configId, ModelMap mmap)
	{
		Config config = configService.selectConfigById(configId);
		mmap.put("config", config);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存参数配置
	 */
	@RequiresPermissions("system:config:edit")
	@Log(title = "参数配置", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Config config)
	{		
		return toAjax(configService.updateConfig(config));
	}
	
	/**
	 * 删除参数配置
	 */
	@RequiresPermissions("system:config:remove")
	@Log(title = "参数配置", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(configService.deleteConfigByIds(ids));
	}

	/**
	 * 校验参数键名
	 */
	@PostMapping("/checkConfigKeyUnique")
	@ResponseBody
	public String checkConfigKeyUnique(Config config)
	{
		String uniqueFlag = "0";
		if (StringUtils.isNotNull(config))
		{
			uniqueFlag = configService.checkConfigKeyUnique(config);
		}
		return uniqueFlag;
	}
	
}
